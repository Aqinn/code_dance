package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/3 10:28 上午
 */
class 至少是其他数字两倍的最大数 {

    /**
     * 题目描述:
     * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
     * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
     * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun dominantIndex(nums: IntArray): Int {
        if (nums.isEmpty())
            return -1
        if (nums.size == 1)
            return 0
        var max = nums[0]
        var maxIdx = 0
        var isDouble = true
        for (i in 1..nums.lastIndex) {
            if (max < nums[i]) {
                isDouble = max * 2 <= nums[i]
                max = nums[i]
                maxIdx = i
            } else {
                isDouble = isDouble && max >= nums[i] * 2
            }
        }
        return if (isDouble) maxIdx else -1
    }

}