package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/5 10:16 下午
 */
class 排列硬币 {

    /**
     * 题目描述:
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     */

    fun arrangeCoins(n: Int): Int {
        if (n <= 0) {
            return 0
        }
        var remain = 0L
        var layer = 0
        while (remain < n) {
            remain += ++layer
        }
        return if (remain > n) layer - 1 else layer
    }

}