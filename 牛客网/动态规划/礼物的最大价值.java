package 牛客网.动态规划;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/1/24 9:23 下午
 */
public class 礼物的最大价值 {

    /**
     * 题目描述:
     * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
     * 游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
     * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，
     * 请设计一个算法使小东拿到价值最高的礼物。
     * <p>
     * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，保证每个礼物价值大于100小于1000。
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        礼物的最大价值 main = new 礼物的最大价值();
        int[][] matrix = new int[][]{
                {426, 306, 641, 372, 477, 409},
                {223, 172, 327, 586, 363, 553},
                {292, 645, 248, 316, 711, 295},
                {127, 192, 495, 208, 547, 175},
                {131, 448, 178, 264, 207, 676},
                {655, 407, 309, 358, 246, 714}
        };
        System.out.println(main.getMost(matrix));
    }

    public int getMost(int[][] board) {
        // dp[][] 到这一格的时候所能获得的最高价值
        // 转移方程为，dp[i][j] = board[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
        int[][] dp = new int[board.length][board[0].length];
        dp[0][0] = board[0][0];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int up = 0, left = 0;
                if (j - 1 >= 0) {
                    left = dp[i][j - 1];
                }
                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }
                dp[i][j] = board[i][j] + Math.max(up, left);
            }
        }
        return dp[board.length - 1][board[0].length - 1];
    }

}
