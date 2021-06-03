package LeetCode.字符串

/**
 * @Author Aqinn
 * @Date 2021/6/3 12:08 下午
 */
class 字符串相加 {

    /**
     * 题目描述:
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 提示：
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
     */

    fun addStrings(num1: String, num2: String): String {
        val n1 = num1.ifEmpty { "0" }.reversed()
        val n2 = num2.ifEmpty { "0" }.reversed()
        var idx = 0
        var remain = 0
        val sb = StringBuilder()
        while (idx < n1.length || idx < n2.length) {
            val i = (if (idx < n1.length) n1[idx].int else 0) + (if (idx < n2.length) n2[idx].int else 0) + remain
            remain = i / 10
            sb.append(i % 10)
            idx++
        }
        if (remain != 0) {
            sb.append(remain)
        }
        return sb.reverse().toString()
    }

    val Char.int: Int
        get() = this - '0'

}

fun main() {
    val main = 字符串相加()
    println(main.addStrings("0", "10000"))
}