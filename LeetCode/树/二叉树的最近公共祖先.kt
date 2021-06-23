package LeetCode.树

/**
 * @Author Aqinn
 * @Date 2021/5/15 11:43 上午
 */
class 二叉树的最近公共祖先 {

    /**
     * 题目描述:
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null || q == null) {
            return null
        }
        if (root == null || root.`val` == p.`val` || root.`val` == q.`val`) return root // 当前点就是

        // 在左子树中找
        val left = lowestCommonAncestor(root.left, p, q)
        // 在右子树中找
        val right = lowestCommonAncestor(root.right, p, q)

        return when {
            // 左右子树中都找到
            left != null && right != null -> root
            // 仅左子树中有
            left != null -> left
            // 仅右子树中有
            else -> right
        }
    }

    // 下面的解法太繁琐
    var res: TreeNode? = null
    fun _lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        containChild(root, p, q)
        return res
    }

    private fun containChild(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
        if (root == null) {
            return false
        }
        val l = containChild(root.left, p, q)
        val r = containChild(root.right, p, q)
        // case 1：本身就是 p 或 q 节点
        // case 2：左右子树中任有一
        if ((l && r) || ((root.`val` == p.`val` || root.`val` == q.`val`) && (l || r))) {
            res = root
        }
        return root.`val` == p.`val` || root.`val` == q.`val` || l || r
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}