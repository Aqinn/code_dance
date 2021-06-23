package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/9 10:53 上午
 */
class 打家劫舍2 {

    /**
     * 题目描述:
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return max(nums[0], nums[1])
        return max(
            rob(nums, 0, nums.size - 2),
            rob(nums, 1, nums.size - 1)
        )
    }

    private fun rob(nums: IntArray, start: Int, end: Int): Int {
        var prepre = nums[start]
        var pre = max(nums[start], nums[start + 1])
        var temp = pre
        ((start + 2)..end).forEach {
            pre = max(prepre + nums[it], pre)
            prepre = temp
            temp = pre
        }
        return pre
    }

}