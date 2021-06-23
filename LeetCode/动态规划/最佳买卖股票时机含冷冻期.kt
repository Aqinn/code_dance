package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/24 9:47 下午
 */
class 最佳买卖股票时机含冷冻期 {

    /**
     * 题目描述:
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun maxProfit(prices: IntArray): Int {
        // dp[i][0] 第 i 天持有股票的最大收益
        // dp[i][1] 第 i 天处于冷冻期的最大收益
        // dp[i][2] 第 i 天不处于冷冻期的最大收益
        val dp = Array(prices.size) { IntArray(3) }
        // 防止第一次冷冻期的计算
        dp[0][0] = -prices[0]
        for (i in 1 until dp.size) {
            // 保持持有 / 买入股票
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i])
            // 以当前价格卖了股票，处于冷冻期
            dp[i][1] = dp[i - 1][0] + prices[i]
            // 保持不买入股票 / 冷冻期结束第一天
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1])
        }
        return max(dp[dp.size - 1][1], dp[dp.size - 1][2])
    }

}