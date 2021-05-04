package LeetCode.树

/**
 * @Author Aqinn
 * @Date 2021/5/4 1:18 下午
 */
class 合并二叉树 {

    /**
     * 题目描述:
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。
     * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
     * 否则不为NULL 的节点将直接作为新二叉树的节点。
     */

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null)
            return root2
        if (root2 == null)
            return root1
        // 现在root1和root2都不是null
        root1.`val` += root2.`val`
        root1.left = mergeTrees(root1.left, root2.left)
        root1.right = mergeTrees(root1.right, root2.right)
        return root1;
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}