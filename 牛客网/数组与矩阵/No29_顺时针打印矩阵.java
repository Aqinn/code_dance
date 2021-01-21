package 牛客网.数组与矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/1/21 2:09 下午
 */
public class No29_顺时针打印矩阵 {

    // cost time => 28:14

    /**
     * 按顺时针的方向，从外到里打印矩阵的值。下图的矩阵打印结果为：
     * 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
     * https://camo.githubusercontent.com/00a529441d838ba0045ce2b217b6bfcc6b7bfbca85003c0dba5c5d314ab1a351/68747470733a2f2f63732d6e6f7465732d313235363130393739362e636f732e61702d6775616e677a686f752e6d7971636c6f75642e636f6d2f696d6167652d32303230313130343031303334393239362e706e67
     */

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {1, 2, 3, 41, 51},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[][] arr2 = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[][] arr3 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printMatrix(arr3);
        List<Integer> list = getMatrixArray(arr3);
        for (Integer i:list) {
            System.out.print(i + " ");
        }
    }

    private static void printMatrix(int[][] matrix) {
        int hb = 0, he = matrix[0].length - 1, wb = 0, we = matrix.length - 1;
        while (hb <= he && wb <= we) {
            // 打印上侧
            for (int i = hb; i <= he; i++) {
                System.out.print(matrix[wb][i] + " ");
            }
            // 打印右侧
            for (int i = wb + 1; i <= we; i++) {
                System.out.print(matrix[i][he] + " ");
            }
            // 打印下侧
            for (int i = he - 1; i >= hb; i--) {
                System.out.print(matrix[we][i] + " ");
            }
            //打印左侧
            for (int i = we - 1; i > wb; i--) {
                System.out.print(matrix[i][hb] + " ");
            }
            hb++;
            he--;
            wb++;
            we--;
        }
        System.out.println();
    }

    private static ArrayList<Integer> getMatrixArray(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 上
            for (int i = c1; i <= c2; i++)
                ret.add(matrix[r1][i]);
            // 右
            for (int i = r1 + 1; i <= r2; i++)
                ret.add(matrix[i][c2]);
            if (r1 != r2)
                // 下
                for (int i = c2 - 1; i >= c1; i--)
                    ret.add(matrix[r2][i]);
            if (c1 != c2)
                // 左
                for (int i = r2 - 1; i > r1; i--)
                    ret.add(matrix[i][c1]);
            r1++; r2--; c1++; c2--;
        }
        return ret;
    }

}
