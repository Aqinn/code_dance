package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/24 9:01 下午
 */
public class 变态跳台阶 {

    // cost time => 5:29

    /**
     * 题目描述:
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        变态跳台阶 main = new 变态跳台阶();
        System.out.println(main.JumpFloorII(3));
    }

    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        int[] dp = new int[target + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] += 1;
            for (int j = i - 1; j > 0; j--) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }

}
