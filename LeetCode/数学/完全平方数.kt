package LeetCode.数学

import kotlin.math.*

/**
 * @Author Aqinn
 * @Date 2021/5/16 1:31 下午
 */
class 完全平方数 {

    /**
     * 题目描述:
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；
     * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     */

    fun numSquares(n: Int): Int {
        if (n <= 0) {
            return 0
        }
        val dp = IntArray(n + 1)
        dp.fill(Int.MAX_VALUE)
        dp[0] = 0
        val squareNums = IntArray(sqrt(n * 1.0).toInt() + 1)
        for (i in 1 until squareNums.size) {
            squareNums[i] = i * i
            dp[squareNums[i]] = 1
        }
        for (idx in dp.indices.filter { it > 0 }) {
            for (square in squareNums.withIndex().filter { it.value < idx && it.index > 0}) {
                dp[idx] = min(dp[idx], dp[idx - square.value] + 1)
            }
        }
        return dp[n]
    }

}

fun main() {
    val main = 完全平方数()
    println(main.numSquares(13))
}