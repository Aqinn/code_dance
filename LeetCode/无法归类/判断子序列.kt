package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/26 8:26 下午
 */
class 判断子序列 {

    /**
     * 题目描述:
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 进阶：
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
     * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // TODO: 2021/5/26 可以使用双指针 

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        if (t.isEmpty()) {
            return false
        }
        if (s[0] == t[0]) {
            return isSubsequence(s.substring(1), t.substring(1))
        } else {
            return isSubsequence(s, t.substring(1))
        }
    }

}

fun main() {
    val main = 判断子序列()
    println(main.isSubsequence("abc", "ahbgdc"))
    println(main.isSubsequence("axc", "ahbgdc"))
}