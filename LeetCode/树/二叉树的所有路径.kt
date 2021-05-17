package LeetCode.树

import java.lang.StringBuilder

/**
 * @Author Aqinn
 * @Date 2021/5/17 10:36 上午
 */
class 二叉树的所有路径 {

    /**
     * 题目描述:
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     */

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val res: MutableList<String> = mutableListOf();
        dfs(root, "", res)
        return res
    }

    private fun dfs(root: TreeNode?, path: String, res: MutableList<String>) {
        // 如果为空，直接返回
        if (root == null) {
            return
        }
        // 如果是叶子节点，说明找到了一条路径，把它加入到res中
        if (root.left == null && root.right == null) {
            res.add(path + root.`val`)
            return
        }
        // 如果不是叶子节点，再分别遍历他的左右子节点
        dfs(root.left, path + root.`val`.toString() + "->", res)
        dfs(root.right, path + root.`val`.toString() + "->", res)
    }

    // 太繁琐了
    private fun dfs(root: TreeNode?, sb: StringBuilder, res: MutableList<String>) {
        if (root == null) {
            return
        }
        addPoint(sb, root.`val`)
        if (root.left == null && root.right == null) {
            res.add(sb.toString())
        } else {
            dfs(root.left, sb, res)
            dfs(root.right, sb, res)
        }
        removePoint(sb)
    }

    private fun addPoint(sb: StringBuilder, `val`: Int) {
        if (sb.isEmpty()) {
            sb.append(`val`)
        } else {
            sb.append("->${`val`}")
        }
    }

    private fun removePoint(sb: StringBuilder) {
        val lastIndexOf = sb.lastIndexOf("->")
        if (lastIndexOf == -1) {
            sb.clear()
        } else {
            sb.delete(lastIndexOf, sb.length)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}

fun main() {

}