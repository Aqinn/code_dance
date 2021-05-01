package LeetCode.字符串

/**
 * @Author Aqinn
 * @Date 2021/5/1 9:12 上午
 */
class 找不同 {

    /**
     * 题目描述:
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     *
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     */

    fun findTheDifference(s: String, t: String): Char {
        val arr: IntArray = IntArray(26)
        for (ch in s) {
            arr[ch.toInt() - 'a'.toInt()]++;
        }
        for (ch in t) {
            val idx = ch.toInt() - 'a'.toInt()
            if (arr[idx] == 0)
                return ch
            else
                arr[idx]--;
        }
        return ' '
    }


}