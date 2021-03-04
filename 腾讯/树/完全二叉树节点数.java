package 腾讯.树;

/**
 * @Author Aqinn
 * @Date 2021/3/4 4:03 下午
 */
public class 完全二叉树节点数 {

    /**
     * 题目描述:
     * 给定一棵完全二叉树的头节点head，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
     */

    public int nodeNum(TreeNode head) {
        if (head == null)
            return 0;
        int leftHeight = getHeight(head.left);
        int rightHeight = getHeight(head.right);
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1 + 1 + nodeNum(head.right);
        } else {
            return (int) Math.pow(2, rightHeight) - 1 + 1 + nodeNum(head.left);
        }
    }

    private int getHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
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
