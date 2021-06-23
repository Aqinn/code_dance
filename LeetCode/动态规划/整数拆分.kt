package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/21 4:13 下午
 */
class 整数拆分 {

    /**
     * 题目描述:
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun integerBreak(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 0
        for (i in 2..n) {
            for (j in (i - 1) downTo 1) {
                dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
            }
        }
        return dp[n]
    }

}