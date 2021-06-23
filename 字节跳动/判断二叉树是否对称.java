package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/16 11:24 下午
 */
public class 判断二叉树是否对称 {

    /**
     * 题目描述:
     * 给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/1b0b7f371eae4204bc4a7570c84c2de1
     */

    /**
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
