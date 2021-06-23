package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/17 2:35 下午
 */
public class 求路径 {

    /**
     * 题目描述:
     * 一个机器人在 m×n 大小的地图的左上角（起点）。
     * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
     * 可以有多少种不同的路径从起点走到终点？
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/166eaff8439d4cd898e3ba933fbc6358
     */

    /**
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[i][j] 到达这一格的所有路径数量
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
