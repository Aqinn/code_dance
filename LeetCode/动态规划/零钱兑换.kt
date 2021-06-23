package LeetCode.动态规划

import kotlin.math.min

/**
 * @Author Aqinn
 * @Date 2021/5/20 10:27 下午
 */
class 零钱兑换 {

    /**
     * 题目描述:
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun coinChange(coins: IntArray, amount: Int): Int {
        if ((coins.isEmpty() && amount != 0) || amount < 0) {
            return -1
        }
        /*
        dp[i] 表示组成金额 i 所需要的最少的硬币个数
        dp[0] = 0, dp[i] = dp[i-x] + 1
         */
        val dp = IntArray(amount + 1)
        dp.fill(amount + 1)
        dp[0] = 0
        for (i in 1..dp.size-1) {
            for (c in coins.filter { it <= i }) {
                dp[i] = min(dp[i], dp[i - c] + 1)
            }
        }
        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }

}