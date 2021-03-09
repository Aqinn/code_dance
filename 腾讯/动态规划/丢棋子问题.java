package 腾讯.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/3/9 9:29 下午
 */
public class 丢棋子问题 {

    /**
     * 题目描述:
     * 一座大楼有 0-N 层，地面算作第 0 层，最高的一层为第 N 层。
     * 已知棋子从第0层掉落肯定不会摔碎，从第 i 层掉落可能会摔碎，也可能不会摔碎（1 <= i <= N）。
     * 给定整数 N 作为楼层数，再给定整数 K 作为棋子数，返回如果想找到棋子不会摔碎的最高层数，即使在最差的情况下扔的最小次数。
     * 一次只能扔一个棋子。
     */

    public int solve(int n, int k) {
        if (n <= 0 || k <= 0)
            return 0;
        int[] dp = new int[k];
        int count = 0;
        int pre = 0;
        while (true) {
            count++;
            pre = 0;
            for (int i = 0; i < k; i++) {
                int temp = dp[i];
                dp[i] = pre + dp[i] + 1;
                pre = temp;
                if (dp[i] >= n)
                    return count;
            }
        }
    }


}
