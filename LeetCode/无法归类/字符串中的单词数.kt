package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/27 12:57 下午
 */
class 字符串中的单词数 {

    /**
     * 题目描述:
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     */

    fun countSegments(s: String): Int {
        if (s.replace(" ", "").isEmpty()) {
            return 0
        }
        return s.trim(' ').split("\\s+".toRegex()).size
    }

}

fun main() {
    val main = 字符串中的单词数()
    println(main.countSegments("         "))
}