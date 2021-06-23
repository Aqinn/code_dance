package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/11 11:54 上午
 */
public class 二叉树根节点到叶子节点的所有路径和 {

    /**
     * 题目描述:
     * 给定一个仅包含数字 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
     * 例如根节点到叶子节点的一条路径是 1 → 2 → 3, 那么这条路径就用 123 来代替。
     * 找出根节点到叶子节点的所有路径表示的数字之和。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83
     */

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers(TreeNode root) {
        // write code here
        getSum(root, root, 0);
        return sum;
    }

    private void getSum(TreeNode root, TreeNode node, int s) {
        if (node == null) {
            return;
        }
        s = s * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += s;
            return;
        }
        getSum(root, node.left, s);
        getSum(root, node.right, s);
    }

    private int sum = 0;

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
