package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/7/9 9:05 上午
 */

/*
题目描述:
数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。
若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。

示例 1：
输入：[1,2,5,9,5,9,5,5,5]
输出：5

示例 2：
输入：[3,2]
输出：-1

示例 3：
输入：[2,2,1,1,1,2,2]
输出：2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-majority-element-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun majorityElement(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var temp = nums[0]
    var count = 1
    for (i in 1 until nums.size) {
        if (count == 0) {
            temp = nums[i]
            count = 1
            continue
        }
        if (nums[i] == temp) {
            count++
        } else {
            count--
        }
    }
    count = 0
    for (n in nums) {
        if (n == temp) {
            count++
        }
    }
    return if (count > nums.size / 2) {
        temp
    } else {
        -1
    }
}