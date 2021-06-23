package 牛客网.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/1/23 5:13 下午
 */
public class 二叉树的深度 {

    // cost time => 10:44

    /**
     * 题目描述:
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73
     */

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    if (count > deep) {
                        deep = count;
                    }
                    continue;
                }
                queue.add(temp.left);
                queue.add(temp.right);
            }
            count++;
        }
        return deep;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
