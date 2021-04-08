package LeetCode.树;

/**
 * @Author Aqinn
 * @Date 2021/4/8 7:47 下午
 */
public class 左叶子之和 {

    /**
     * 题目描述:
     * 计算给定二叉树的所有左叶子之和
     */

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        travel(root);
        return sum;
    }

    private void travel(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        else
            travel(root.left);
        travel(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
