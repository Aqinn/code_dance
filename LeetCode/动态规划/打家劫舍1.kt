package LeetCode.动态规划

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/5/9 10:53 上午
 */
class 打家劫舍1 {

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