package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/23 10:37 下午
 */
public class 最大正方形 {

    /**
     * 题目描述:
     * 给定一个由 0 和 1 组成的 2 维矩阵，返回该矩阵中最大的由 1 组成的正方形的面积
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/0058c4092cec44c2975e38223f10470e
     */

    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        // dp[i][j] 以 matrix[i][j]为右下角的最大值正方形边长
        // 初始化dp[][]
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            if (dp[i][0] == 1) {
                max = 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            if (dp[0][i] == 1) {
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
