package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/9 10:53 上午
 */
class 打家劫舍1 {

    /**
     * 题目描述:
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */

    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return max(nums[0], nums[1])
        var prepre = nums[0]
        var pre = max(nums[0], nums[1])
        var temp = pre
        (2 until nums.size).forEach {
            pre = max(prepre + nums[it], pre)
            prepre = temp
            temp = pre
        }
        return pre
    }

}