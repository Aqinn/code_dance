package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 2:14 下午
 */
public class 平衡二叉树 {

    /**
     * 题目描述:
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
     **/

    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root);
        return balance;
    }

    private boolean balance = true;

    private int getHeight(TreeNode node) {
        if (node == null || !balance) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (Math.abs(left - right) > 1){
            balance = false;
            return 0;
        }
        return 1 + Math.max(left, right);
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
    }

}
