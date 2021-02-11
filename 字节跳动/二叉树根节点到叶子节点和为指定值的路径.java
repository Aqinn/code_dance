package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/2/11 12:16 下午
 */
public class 二叉树根节点到叶子节点和为指定值的路径 {

    /**
     * 题目描述:
     * 给定一个二叉树和一个值 sum，请找出所有的根节点到叶子节点的节点值之和等于 sum 的路径，
     */

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, sum, res);
        return res;
    }

    private int tempSum = 0;
    private ArrayList<Integer> temp = new ArrayList<>();

    private void dfs(TreeNode node, int target, ArrayList<ArrayList<Integer>> res) {
        if (node == null)
            return;
        temp.add(node.val);
        tempSum += node.val;
        if (node.left == null && node.right == null) {
            if (tempSum == target) {
                res.add(new ArrayList<Integer>(temp));
            }
        }
        dfs(node.left, target, res);
        dfs(node.right, target, res);
        temp.remove(temp.size() - 1);
        tempSum -= node.val;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
