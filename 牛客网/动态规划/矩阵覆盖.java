package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/24 4:43 下午
 */
public class 矩阵覆盖 {

    // cost time => 22:36

    /**
     * 题目描述:
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * 来源：牛客
     * 链接：
     */

    public int rectCover(int target) {
        if (target <= 0)
            return 0;
        int[] dp = new int[target + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

}
