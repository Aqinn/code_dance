package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 5:27 下午
 */
public class 平衡二叉树 {

    // cost time => 6:35

    /**
     * 题目描述:
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：
     * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
     */

    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root);
        return isBalance;
    }

    private boolean isBalance = true;
    private int getHeight(TreeNode root) {
        if (root == null || !isBalance) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(left, right);
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
