package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/24 4:38 下午
 */
public class 斐波那契数列 {

    // cost time => 3:49

    /**
     * 题目描述:
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
     */

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
