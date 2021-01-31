package 字节跳动;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/1/31 10:55 上午
 */
public class 二叉树的之字形层序遍历 {

    /**
     * 题目描述:
     * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
     */

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = q.poll();
                if (temp == null)
                    continue;
                if (flag) {
                    list.add(temp.val);
                } else {
                    list.add(0, temp.val);
                }
                q.add(temp.left);
                q.add(temp.right);
            }
            flag = !flag;
            if (list.size() > 0)
                res.add(list);
        }
        return res;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
