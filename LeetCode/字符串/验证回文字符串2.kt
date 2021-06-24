package LeetCode.字符串

/**
 * @Author Aqinn
 * @Date 2021/6/24 4:46 下午
 */

/*
题目描述:
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:
输入: "aba"
输出: True

示例 2:
输入: "abca"
输出: True
解释: 你可以删除c字符。

注意:
字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun validPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }
    return isPalindromeAllowOneError(s)
}

fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    while (start < end) {
        if (s[start] != s[end]) {
            return false
        }
        start++
        end--
    }
    return true
}

fun isPalindromeAllowOneError(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    while (start < end) {
        if (s[start] != s[end]) {
            return isPalindrome(s.substring(0, start) + s.substring(start + 1)) ||
                    isPalindrome(s.substring(0, end) + s.substring(end + 1))
        }
        start++
        end--
    }
    return true
}