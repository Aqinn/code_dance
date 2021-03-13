package 美团.无法分类;

import java.util.Scanner;

/**
 * @Author Aqinn
 * @Date 2021/3/13 11:23 下午
 */
public class 翻转矩阵 {

    /**
     * 2021 春招 美团笔试第一题
     * 题目描述:
     * 如题
     * 输入:
     * 3 3
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * <p>
     * 输出:
     * 1 4 7
     * 2 5 8
     * 3 6 9
     */

    // 不是最优做法，牺牲了空间，但获取了更多后面的做题时间
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  // 行
        int m = input.nextInt();  // 列
        int nmMax = Math.max(n, m);
        int[][] arr = new int[nmMax][nmMax];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        // 直接对角线翻转
        for (int i = 0; i < nmMax; i++) {
            for (int j = i; j < nmMax; j++) {
                if (i == j)
                    continue;
                swap(arr, i, j);
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1)
                    System.out.println(res[i][j]);
                else
                    System.out.print(res[i][j] + " ");
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

}
