package LeetCode.字符串

/**
 * @Author Aqinn
 * @Date 2021/6/30 3:27 下午
 */

/*
题目描述:
给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"

示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"

提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

题解:
https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */

fun longestPalindrome(s: String): String {
    if (s.length == 1) {
        return s
    }
    val dp = Array(s.length) { BooleanArray(s.length) }
    for (i in s.indices) {
        dp[i][i] = true
    }
    var ans = "${s[0]}"
    for (len in 2..s.length) {
        for (left in s.indices) {
            val right = left + len - 1
            if (right >= s.length) {
                break
            }
            if (s[left] != s[right]) {
                dp[left][right] = false
                continue
            }
            if (len == 2) {
                dp[left][right] = true
            } else {
                dp[left][right] = dp[left + 1][right - 1]
            }
            if (dp[left][right] && ans.length < len) {
                ans = s.substring(left, right + 1)
            }
        }
    }
    return ans
}