package LeetCode.树

/**
 * @Author Aqinn
 * @Date 2021/5/14 12:30 下午
 */
class 二叉搜索树中第K小的元素 {

    /**
     * 题目描述:
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     */

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) {
            return 0
        }
        val res = mutableListOf<Int>()
        midTraverse(root, k, res)
        return res.get(k - 1)
    }

    private fun midTraverse(root: TreeNode, k: Int, memo: MutableList<Int>) {
        if (root.left != null) {
            midTraverse(root.left!!, k, memo)
        }
        memo.add(root.`val`)
        if (root.right != null) {
            midTraverse(root.right!!, k, memo)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}

fun main() {
    val n0 = 二叉搜索树中第K小的元素.TreeNode(3)
    val n1 = 二叉搜索树中第K小的元素.TreeNode(2)
    val n2 = 二叉搜索树中第K小的元素.TreeNode(4)
    val n3 = 二叉搜索树中第K小的元素.TreeNode(1)
    n0.left = n1
    n0.right = n2
    n1.left = n3
    println(二叉搜索树中第K小的元素().kthSmallest(n0, 1))
}