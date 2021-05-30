package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/5/30 10:47 上午
 */
class 移除K位数字 {

    /**
     * 题目描述:
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * 注意:
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     */

    fun removeKdigits(num: String, k: Int): String {
        if (k >= num.length) {
            return "0"
        }
        val sb = StringBuilder(num)
        var idx = 1
        var deleteCount = 0
        while (idx < sb.length) {
            if (sb[idx - 1] > sb[idx]) {
                sb.deleteCharAt(idx - 1)
                if (idx != 1)
                    idx--
                deleteCount++
                if (deleteCount == k) {
                    break
                }
            } else {
                idx++
                if (idx >= sb.length && deleteCount < k) {
                    for (i in 1..(k - deleteCount)) {
                        sb.deleteCharAt(sb.length - 1)
                    }
                    break
                }
            }
        }
        val res = sb.toString()
        return if (res.replace("0", "").isEmpty()) "0" else sb.toString().trimStart('0')
    }

}

fun main() {
    val main = 移除K位数字()
    println(main.removeKdigits("10", 2))
}