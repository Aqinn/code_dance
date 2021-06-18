package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/18 11:27 下午
 */

/**
题目描述:
给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */

fun thirdMax(nums: IntArray): Int {
    var biggest: Int = nums.first()
    var bigger: Int? = null
    var big: Int? = null
    for (num in nums) {
        if (num == bigger || num == biggest) continue
        when {
            num > biggest -> {
                big = bigger
                bigger = biggest
                biggest = num
            }
            bigger == null -> bigger = num
            num > bigger -> {
                big = bigger
                bigger = num
            }
            big == null -> big = num
            num > big -> big = num
        }
    }
    return big ?: biggest
}

