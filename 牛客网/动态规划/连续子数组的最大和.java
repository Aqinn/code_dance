package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/24 9:07 下午
 */
public class 连续子数组的最大和 {

    // cost time => 14:22

    /**
     * 题目描述:
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为 O(n).
     * <p>
     * 输入
     * [1,-2,3,10,-4,7,2,-5]
     * <p>
     * 输出
     * 18
     * <p>
     * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
     */

    public static void main(String[] args) {
        连续子数组的最大和 main = new 连续子数组的最大和();
        System.out.println(main.FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }

    // dp[i] : 以 array[i] 结尾的子数组的最大子数组和
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length + 1];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

}
