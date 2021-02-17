package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/17 1:41 下午
 */
public class 矩阵元素查找 {

    /**
     * 题目描述:
     * 已知 int 一个有序矩阵 mat，同时给定矩阵的大小 n 和 m 以及需要查找的元素 x，且矩阵的行和列都是从小到大有序的。
     * 设计查找算法返回所查找元素的二元数组，代表该元素的行号和列号 (均从零开始)。保证元素互异。
     */

    public int[] findElement(int[][] mat, int n, int m, int x) {
        int i = 0, j = m - 1;
        int[] res = new int[]{-1, -1};
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                res[0] = i;
                res[1] = j;
                return res;
            } else if (mat[i][j] < x) {
                i++;
            } else if (mat[i][j] > x) {
                j--;
            }
        }
        return res;
    }

}
