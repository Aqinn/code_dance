package LeetCode.数学

import kotlin.math.log10

/**
 * @Author Aqinn
 * @Date 2021/6/16 3:20 下午
 */

/**
题目描述:
编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。

示例:
输入: 25
输出: 9
解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)

提示：
n <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun _numberOf2sInRange(n: Int): Int {
    var res = 0
    for (i in 0..n) {
        res += count2(i)
    }
    return res
}

fun count2(n: Int): Int {
    var count = 0
    var t = n
    while (t != 0) {
        if (t % 10 == 2) {
            count++
        }
        t /= 10
    }
    return count
}

// 妙妙妙
fun numberOf2sInRange(n: Int): Int {
    if (n <= 1) {
        return 0
    }
    val bitCount = log10(n.toFloat()).toInt() + 1
    // dp[i][0] 代表 numberOf2sInRange(n 的第 1 至 i 位数组成的数字)
    // dp[i][1] 代表 numberOf2sInRange(10 ^ i) - 1
    val dp = Array(bitCount + 1) { IntArray(2) }
    dp[1][0] = if (n % 10 >= 2) 1 else 0
    dp[1][1] = 1
    for (i in 2..bitCount) {
        val k = n / 10.pow(i - 1) % 10
        dp[i][0] = dp[i - 1][1] * k + dp[i - 1][0]
        if (k == 2) {
            dp[i][0] += (n % 10.pow(i - 1) + 1)
        } else if (k > 2) {
            dp[i][0] += 10.pow(i - 1)
        }
        dp[i][1] = dp[i - 1][1] * 10 + 10.pow(i - 1)
    }
    return dp[bitCount][0]
}

fun Int.pow(n: Int): Int {
    var res = 1
    for (i in 1..n) {
        res *= this
    }
    return res
}

fun main() {
    println(numberOf2sInRange(559366752))
    // 输入 559366752
    // 输出 551687056
}