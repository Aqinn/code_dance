package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/2 1:56 下午
 */
class 等差数列划分 {

    /**
     * 题目描述:
     * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     *
     * 例如，以下数列为等差数列:
     * 1, 3, 5, 7, 9
     * 7, 7, 7, 7
     * 3, -1, -5, -9
     * 以下数列不是等差数列。
     * 1, 1, 2, 5, 7
     *
     * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
     * 如果满足以下条件，则称子数组(P, Q)为等差数组：
     * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
     * 函数要返回数组 A 中所有为等差数组的子数组个数。
     *
     * 示例:
     * A = [1, 2, 3, 4]
     * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
     */

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var res = 0
        var i = 0
        while (i < nums.size) {
            val temp = findArithmeticSlices(nums, i)
            if (temp == 0) {
                i++
            } else {
                res += getSubArrayNum(temp - i + 1)
                i = temp
            }
        }
        return res
    }

    /**
     * 从下标 idx 开始找，如果有等差数列则返回最长等差数列的结尾下标，如果无则返回 0
     */
    private fun findArithmeticSlices(nums: IntArray, idx: Int): Int {
        if (nums.size - idx < 3) {
            return 0
        }
        val sub = nums[idx + 1] - nums[idx]
        if (nums[idx + 2] - nums[idx + 1] != sub) {
            return 0
        }
        for (i in (idx + 3) until nums.size) {
            if (nums[i] - nums[i - 1] != sub) {
                return i - 1
            }
        }
        return nums.size - 1
    }

    private fun getSubArrayNum(n: Int): Int {
        if (n < 3) {
            return 0
        }
        if (n == 3) {
            return 1
        }
        return (n - 1) * (n - 2) / 2
    }

}

fun main() {
    val main = 等差数列划分()
    println(main.numberOfArithmeticSlices(intArrayOf(1)))
}