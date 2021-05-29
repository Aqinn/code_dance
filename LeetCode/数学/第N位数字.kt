package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/5/29 2:03 下午
 */
class 第N位数字 {

    /**
     * 题目描述:
     * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
     */

    fun findNthDigit(n: Int): Int {
        // 找到是几位数
        var level = 1
        var remain: Long = 0
        while (true) {
            val add: Long = 9 * 10.pow(level - 1) * level.toLong()
            if (n > remain + add) {
                level++
                remain += add
            } else {
                break
            }
        }
        // 找到在 level 位数中是第几个数字 & 第几位数
        val temp = n - remain
        val count = (temp - 1) / level  // 从 0 开始
        val bit = ((temp - 1) % level).toInt()  // 从 0 开始
        val target: Long = 10.pow(level - 1) + count
        return (target / 10.pow(level - 1 - bit) % 10).toInt()
    }

    fun Int.pow(n: Int): Int {
        if (n == 0) {
            return 1
        }
        var res = this
        for (i in 1 until n) {
            res *= this
        }
        return res
    }

}

fun main() {
    val main = 第N位数字()
    println(main.findNthDigit(1000000000))
}