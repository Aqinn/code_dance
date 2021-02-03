package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 2:57 下午
 */
public class 二叉树的最大深度 {

    /**
     * 题目描述:
     * 求给定二叉树的最大深度，
     * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
     */

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
