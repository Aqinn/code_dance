package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/19 5:15 下午
 */
public class 顺时针旋转矩阵 {

    /**
     * 题目描述:
     * 有一个 NxN 整数矩阵，请编写一个算法，将矩阵顺时针旋转 90 度。
     * 给定一个 NxN 的矩阵，和矩阵的阶数 N, 请返回旋转后的 NxN 矩阵，保证 N 小于等于 300。
     */

    public int[][] rotateMatrix(int[][] mat, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }

}
