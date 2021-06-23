package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/31 12:10 下午
 */
public class 螺旋矩阵 {

    /**
     * 题目描述:
     * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31
     */

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int width = matrix.length - 1, length = matrix[0].length - 1;
        int startX = 0, startY = 0;
        while (startY <= width && startX <= length) {
            // 输出上面
            for (int i = startX; i <= length; i++) {
                res.add(matrix[startY][i]);
            }
            // 输出右边
            for (int i = startY + 1; i <= width; i++) {
                res.add(matrix[i][length]);
            }
            // 输出下面
            if (startY != width) {
                for (int i = length - 1; i >= startX; i--) {
                    res.add(matrix[width][i]);
                }
            }
            // 输出左边
            if (startX != length) {
                for (int i = width - 1; i > startY; i--) {
                    res.add(matrix[i][startX]);
                }
            }
            startY++;
            width--;

            startX++;
            length--;
        }

        return res;
    }

}
