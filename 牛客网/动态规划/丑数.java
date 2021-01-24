package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/24 10:07 下午
 */
public class 丑数 {

    // cost time => 49:53

    /**
     * 题目描述:
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */

    public static void main(String[] args) {
        丑数 main = new 丑数();
        System.out.println(main.GetUglyNumber_Solution(7));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 6)
            return index;
        int two = 1, three = 1, five = 1;
        int[] dp = new int[index + 1];
        // dp[i] 代表第N个丑数
        // 动态转移方程
        // two three five 代表 x2x3x5 的最小被乘数值的下标
        // Q1: 什么是最小被乘数值？（也就是 某数x2x3x5中 的某数）
        // Q2: 为什么是下标？（因为被乘的数值同时肯定也存在于 dp 数组中，且比 dp[i] 考前，这样的 dp[i] 乘上 2、3、5 才能得到全是质因数仅有 2、3、5 的数）
        // dp[i] 为 各个下标值x2x3x5 后的较小值
        dp[1] = 1;
        for (int i = 2; i <= index; i++) {
            int mulTwo = 2 * dp[two];
            int mulThree = 3 * dp[three];
            int mulFive = 5 * dp[five];
            int res = Math.min(mulTwo, Math.min(mulThree, mulFive));
            dp[i] = res;
            if (res == mulTwo)
                two++;
            if (res == mulThree)
                three++;
            if (res == mulFive)
                five++;
        }
        return dp[index];
    }

}
