package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/27 12:05 下午
 */

/*
题目描述:
给你一个字符串 s 和一个整数 k ，
请你找出 s 中的最长子串要求该子串中的每一字符出现次数都不少于 k 。
返回这一子串的长度。

示例 1：
输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。

示例 2：
输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

提示：
1 <= s.length <= 104
s 仅由小写英文字母组成
1 <= k <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

fun longestSubstring(s: String, k: Int): Int {
    val memo = BooleanArray(s.length).apply {
        this.fill(true)
    }
    solve(s, k, memo, 0, s.length - 1)
    println(memo.contentToString())
    var max = 0
    var count = 0
    for (flag in memo) {
        if (flag) {
            count++
        } else {
            max = if (max < count) count else max
            count = 0
        }
    }
    return if (max < count) count else max
}

val arr = IntArray(26)

fun solve(str: String, key: Int, memo: BooleanArray, start: Int, end: Int) {
    if (end - start + 1 < key) {
        memo.fill(false, start, end + 1)
        return
    }
    arr.fill(0)
    for (i in start..end) {
        arr[str[i].int]++
    }
    for (i in start..end) {
        val ch = str[i]
        if (arr[ch.int] < key) {
            memo[i] = false
        }
    }
    var count = 0
    for (i in start..end) {
        if (memo[i]) {
            count++
        } else {
            if (count < key) {
                memo.fill(false, i - count, i)
            } else {
                solve(str, key, memo, i - count, i - 1)
            }
            count = 0
        }
    }
    if (count < key) {
        memo.fill(false, end - count + 1, end + 1)
    } else {
        if (start == end - count + 1) {
            return
        }
        solve(str, key, memo, end - count + 1, end)
    }
}

val Char.int
    get() = this - 'a'

fun main() {
    println(longestSubstring("aaabbb", 3))
    println(longestSubstring("a", 2))
}