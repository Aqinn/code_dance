package 字节跳动;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/2/19 5:52 下午
 */
public class 判断一颗二叉树是否为搜索二叉树和完全二叉树 {

    /**
     * 题目描述:
     * 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/f31fc6d3caf24e7f8b4deb5cd9b5fa97
     */

    public boolean[] judgeIt(TreeNode root) {
        boolean[] res = new boolean[2];
        res[0] = judgeSearchBinTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        res[1] = judgeCompleteBinTree(root);
        return res;
    }

    private boolean judgeSearchBinTree(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return judgeSearchBinTree(root.left, min, root.val) &&
                judgeSearchBinTree(root.right, root.val, max);
    }

    private boolean judgeCompleteBinTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode temp = queue.poll();
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
