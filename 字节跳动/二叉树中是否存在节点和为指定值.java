package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/22 11:06 上午
 */
public class 二叉树中是否存在节点和为指定值 {

    /**
     * 题目描述:
     * 给定一个二叉树和一个值 sum，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径，
     */

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (flag)
            return false;
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (sum == root.val)
                flag = true;
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    private boolean flag = false;

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
