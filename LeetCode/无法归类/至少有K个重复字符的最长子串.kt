package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/27 12:05 下午
 */
class 至少有K个重复字符的最长子串 {

    /**
     * 题目描述:
     * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
     * 要求该子串中的每一字符出现次数都不少于 k 。
     * 返回这一子串的长度。
     * 子串是连续的。
     */

    fun longestSubstring(s: String, k: Int): Int {
        val map = HashMap<Char, Int>()
        for (ch in s) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }
        return map.values.filter { it >= k }.sum()
    }

}