package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/31 8:12 下午
 */
class 替换后的最长重复字符 {

    /**
     * 题目描述:
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
     * 在执行上述操作后，找到包含重复字母的最长子串的长度。
     */

    fun characterReplacement(s: String, k: Int): Int {
        val len = s.length
        if (len < 2) {
            return len
        }
        var left = 0
        var right = 0
        var maxCount = 0
        var res = 0
        val freq = IntArray(26)
        while (right < len) {
            freq[s[right] - 'A']++
            maxCount = max(maxCount, freq[s[right] - 'A'])
            right++
            if (right - left > maxCount + k) {
                freq[s[left] - 'A']--
                left++
            }
            res = max(res, right - left)
        }
        return res
    }

}