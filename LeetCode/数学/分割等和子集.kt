package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/4 6:01 下午
 */
class 分割等和子集 {

    /**
     * 题目描述:
     * 给你一个只包含正整数 的 非空 数组 nums 。
     * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun canPartition(nums: IntArray): Boolean {
        if (nums.size < 2) {
            return false
        }
        val sum = nums.sum()
        if (sum % 2 != 0) {
            return false
        }
        // 问题转换：选出x个数，使和为sum/2
        val target = sum / 2
        // dp[i][j] 代表 0~i 的下标范围内，是否能组成和为 j 的组合
        val dp = Array(nums.size) { BooleanArray(target + 1) }
        // 和为 0 的组合，大家都可以
        for (i in dp.indices) {
            dp[i][0] = true
        }
        if (nums[0] <= target)
            dp[0][nums[0]] = true
        for (i in 1 until nums.size) {
            for (j in 1..target) {
                // 当前判断的数字比目标和还大，不用选了，直接等于上一个
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
                }
            }
        }
        return dp[nums.size - 1][target]
    }
}

fun main() {
    val main = 分割等和子集()
    println(main.canPartition(intArrayOf(9, 5)))
}
