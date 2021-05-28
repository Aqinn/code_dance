package LeetCode.无法归类

import kotlin.math.abs

/**
 * @Author Aqinn
 * @Date 2021/5/28 9:45 下午
 */
class 找到所有数组中消失的数字 {

    /**
     * 题目描述:
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
     * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     */

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (idx in nums.indices) {
            nums[abs(nums[idx]) - 1] = -abs(nums[abs(nums[idx]) - 1])
        }
        val res = ArrayList<Int>()
        for (idx in nums.indices) {
            if (nums[idx] > 0) {
                res.add(idx + 1)
            }
        }
        return res
    }

}
