package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/18 2:51 下午
 */
class 最长递增子序列 {

    /**
     * 题目描述:
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     */

    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        // dp[i] 表示长度为 1 的子序列的最后一个数坐标
        val dp = IntArray(nums.size + 1)
        dp[1] = 0
        var res = 1
        for ((idx, value) in nums.withIndex()) {
            for (i in res downTo 1) {
                if (i == 1 && value < nums[dp[1]]) {
                    dp[1] = idx
                    break
                }
                if (value > nums[dp[i]]) {
                    dp[i + 1] = idx
                    res = max(res, i + 1)
                    break
                }
            }
        }
        return res
    }

}