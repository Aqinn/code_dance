package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/31 8:38 上午
 */
public class 在二叉树中找到两个节点的最近公共祖先节点 {

    /**
     * 题目描述:
     * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
     */

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null)
            return -1;
        if (root.val == o1)
            return o1;
        if (root.val == o2)
            return o2;
        int left = root.left == null ? -1 : lowestCommonAncestor(root.left, o1, o2);
        int right = root.right == null ? -1 : lowestCommonAncestor(root.right, o1, o2);
        if (left == -1 && right == -1)
            return -1;
        if (left != -1 && right != -1)
            return root.val;
        return left == -1 ? right : left;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
