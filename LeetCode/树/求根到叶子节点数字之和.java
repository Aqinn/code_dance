package LeetCode.树;

/**
 * @Author Aqinn
 * @Date 2021/1/29 12:31 下午
 */
public class 求根到叶子节点数字之和 {

    /**
     * 题目描述:
     * 给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。
     * <p>
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     * <p>
     * 计算从根到叶子节点生成的所有数字之和。
     */

    public int sumNumbers(TreeNode root) {
        comp(root);
        return sum;
    }

    private int sum = 0;
    private void comp(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += root.val;
        } else {
            if (root.left != null) {
                root.left.val += root.val * 10;
                comp(root.left);
            }
            if (root.right != null) {
                root.right.val += root.val * 10;
                comp(root.right);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
