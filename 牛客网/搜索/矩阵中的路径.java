package 牛客网.搜索;

/**
 * @Author Aqinn
 * @Date 2021/1/23 10:37 下午
 */
public class 矩阵中的路径 {

    /**
     * 题目描述:
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     */

    public static void main(String[] args) {
        矩阵中的路径 main = new 矩阵中的路径();
        char[] matrix = "ABCESFCSADEE".toCharArray();
        System.out.println(main.hasPath(matrix, 3, 4, "ABCCC".toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] been = new int[rows * cols + 1];
                if (match(matrix, rows, cols, i, j, str, 0, been)) {
                    return true;
                }
            }
        }
        return false;
    }

    void showMatrix(int[] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i * rows + j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean match(char[] matrix, int rows, int cols, int row, int col, char[] str, int begin, int[] been) {
//        showMatrix(been, rows, cols);
        if (matrix[row * cols + col] == str[begin]) {
            // 是否全部匹配成功？
            if (begin == str.length - 1)
                return true;
            // 如果匹配上了，那就看看上下左右的匹不匹配剩下的字符
            been[row * cols + col] = 1;
            boolean left = false, right = false, up = false, down = false;
            // 左
            if (col - 1 >= 0 && been[row * cols + (col - 1)] != 1) {
                left = match(matrix, rows, cols, row, col - 1, str, begin + 1, been);
                if (left)
                    return true;
            }
            // 右
            if (col + 1 < cols && been[row * cols + (col + 1)] != 1) {
                right = match(matrix, rows, cols, row, col + 1, str, begin + 1, been);
                if (right)
                    return true;
            }
            // 上
            if (row - 1 >= 0 && been[(row - 1) * cols + col] != 1) {
                up = match(matrix, rows, cols, row - 1, col, str, begin + 1, been);
                if (up)
                    return true;
            }
            // 下
            if (row + 1 < rows && been[(row + 1) * cols + col] != 1) {
                down = match(matrix, rows, cols, row + 1, col, str, begin + 1, been);
                if (down)
                    return true;
            }
            // 如果上下左右都不匹配，证明这条路白走
            been[row * cols + col] = 0;
            return false;
        } else {
            return false;
        }
    }

}
