package code_dance.LeetCode.数学

/*
题目描述:
统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

限制：
0 <= 数组长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty() || target < nums[0] || target > nums[nums.size - 1]) {
        return 0
    }
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    if (left == nums.size || nums[left] != target) {
        return 0
    }
    val temp = left
    right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left - temp
}

fun main() {
    println(search(intArrayOf(1), 1))
    println(search(intArrayOf(5, 7, 7, 8, 8, 10), 8))
}