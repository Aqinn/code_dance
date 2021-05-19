package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/19 12:56 下午
 */
class 打家劫舍3 {

    /**
     * 题目描述:
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
     * 这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
     * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *     3
     *   /   \
     *  2    3
     *  \     \
     *   3     1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     */

    fun rob(root: TreeNode?): Int {
        val pick = mutableMapOf<TreeNode?, Int>()
        val unpick = mutableMapOf<TreeNode?, Int>()
        solve(root, pick, unpick)
        return max(pick[root]!!, unpick[root]!!)
    }

    private fun solve(root: TreeNode?, pick: MutableMap<TreeNode?, Int>, unpick: MutableMap<TreeNode?, Int>) {
        if (root == null) {
            return
        }
        solve(root.left, pick, unpick)
        solve(root.right, pick, unpick)
        pick[root] = root.`val` + unpick.getOrDefault(root.left, 0) + unpick.getOrDefault(root.right, 0)
        unpick[root] = max(pick.getOrDefault(root.left, 0), unpick.getOrDefault(root.left, 0)) + max(
            pick.getOrDefault(
                root.right,
                0
            ), unpick.getOrDefault(root.right, 0)
        )
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}

fun main() {
    val main = 打家劫舍3()
    val root = 打家劫舍3.TreeNode(3)
    val n1 = 打家劫舍3.TreeNode(4)
    val n2 = 打家劫舍3.TreeNode(5)
    val n3 = 打家劫舍3.TreeNode(1)
    val n4 = 打家劫舍3.TreeNode(3)
    val n5 = 打家劫舍3.TreeNode(1)
    root.left = n1
    root.right = n2
    n1.left = n3
    n1.right = n4
    n2.right = n5
    println(main.rob(root))
}