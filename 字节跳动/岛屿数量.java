package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 2:36 下午
 */
public class 岛屿数量 {

    /**
     * 题目描述:
     * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e
     */

    public int solve(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    clear(grid, i, j);
                }
            }
        }
        return count;
    }

    private void clear(char[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length|| grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        clear(grid, i, j-1);
        clear(grid, i, j+1);
        clear(grid, i-1, j);
        clear(grid, i+1, j);
    }

}
