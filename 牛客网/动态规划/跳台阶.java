package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/24 5:08 下午
 */
public class 跳台阶 {

    // cost time => 1:30


    /**
     * 题目描述:
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
     */

    public int JumpFloor(int target) {
        if (target <= 0)
            return 0;
        int[] dp = new int[target + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

}
