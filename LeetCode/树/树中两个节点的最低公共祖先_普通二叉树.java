package LeetCode.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 5:36 下午
 */
public class 树中两个节点的最低公共祖先_普通二叉树 {

    /**
     * 题目描述:
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 说明:
     * <p>
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        return right;
    }

    public TreeNode _lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        boolean left = find(root.left, p) || find(root.left, q);
        boolean right = find(root.right, p) || find(root.right, q);
        if (root.val == p.val || root.val == q.val) {
            if (left || right)
                return root;
        }
        if (left && right) {
            return root;
        } else {
            if (left) {
                return _lowestCommonAncestor(root.left, p, q);
            } else {
                return _lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    private boolean find(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        if (root.val == node.val)
            return true;
        else
            return find(root.left, node) || find(root.right, node);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
