package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/22 2:28 下午
 */
class 最大单词长度乘积 {

    /**
     * 题目描述:
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
     * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 暴力解
    fun maxProduct(words: Array<String>): Int {
        if (words.size < 2) {
            return 0
        }
        var res = 0
        for (i in words.indices) {
            for (j in (i + 1) until words.size) {
                val target = words[i]
                val cur = words[j]
                if (!hasSameChar(target, cur)) {
                    res = max(res, target.length * cur.length)
                }
            }
        }
        return res
    }

    private fun hasSameChar(s1: String, s2: String): Boolean {
        val arr = BooleanArray(26)
        for (ch in s1) {
            arr[ch - 'a'] = true
        }
        for (ch in s2) {
            if (arr[ch - 'a']) {
                return true
            }
        }
        return false
    }

}