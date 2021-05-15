package LeetCode.树

/**
 * @Author Aqinn
 * @Date 2021/5/15 11:43 上午
 */
class 二叉树的最近公共祖先 {

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