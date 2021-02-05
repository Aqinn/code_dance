package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/5 11:09 下午
 */
public class 矩阵的最小路径和 {

    /**
     * 题目描述:
     * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
     * 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
     */

    public int minPathSum(int[][] matrix) {
        // write code here
        if (matrix == null)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int up = 0, left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                if (i > 0 && j > 0)
                    dp[i][j] = matrix[i][j] + Math.min(left, up);
                else if (i > 0)
                    dp[i][j] = matrix[i][j] + up;
                else if (j > 0)
                    dp[i][j] = matrix[i][j] + left;
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }

}
