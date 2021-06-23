package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/4 9:48 上午
 */
public class 二叉树最大路径和 {

    /**
     * 题目描述:
     * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
     * 这个路径的开始节点和结束节点可以是二叉树中的任意节点
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a
     */

    public int maxPathSum(TreeNode root) {
        // write code here
        getMax(root);
        return max;
    }

    private int max = Integer.MIN_VALUE;

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        max = Math.max(max,
                Math.max(
                        Math.max(left, right) + root.val,
                        left + right + root.val)
        );
        return Math.max(0, Math.max(left, right)) + root.val;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
