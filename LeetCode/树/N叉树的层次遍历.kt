package LeetCode.树

import java.util.*

/**
 * @Author Aqinn
 * @Date 2021/6/1 1:08 下午
 */
class N叉树的层次遍历 {

    /**
     * 题目描述:
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     */

    fun levelOrder(root: Node?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val q = LinkedList<Node?>()
        q.offerLast(root)
        while (q.isNotEmpty()) {
            var count = q.size
            val temp = mutableListOf<Int>()
            while (count-- > 0) {
                val pollFirst = q.pollFirst()
                pollFirst?.run {
                    temp.add(`val`)
                    children.map {
                        q.offerLast(it)
                    }
                }
            }
            if (temp.isNotEmpty())
                res.add(temp)
        }
        return res
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

}