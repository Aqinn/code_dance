package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/10 11:39 下午
 */
public class 矩阵查找 {

    /**
     * 题目描述:
     * 请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
     * 每一行的数字都从左到右排序
     * 每一行的第一个数字都比上一行最后一个数字大
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/5145394607ea4c5f8b25755718bfddba
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        // write code here
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
            if (i >= row || j < 0) {
                return false;
            }
        }
        return false;
    }

}
