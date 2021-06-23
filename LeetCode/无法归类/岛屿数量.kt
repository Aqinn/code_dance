package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/8 6:58 上午
 */
class 岛屿数量 {

    /*
     * 题目描述:
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    count += 1
                    clearGrid(grid, i, j)
                }
            }
        }
        return count
    }

    private fun clearGrid(grid: Array<CharArray>, i: Int, j: Int) {
        if (!grid.indices.contains(i) ||
            !grid[i].indices.contains(j) ||
            grid[i][j] == '0'
        ) return
        grid[i][j] = '0'
        clearGrid(grid, i - 1, j)
        clearGrid(grid, i + 1, j)
        clearGrid(grid, i, j - 1)
        clearGrid(grid, i, j + 1)
    }

}

fun main() {
    val grid: Array<CharArray> = arrayOf(
        arrayOf('1', '1', '0', '0', '0').toCharArray(),
        arrayOf('1', '1', '0', '0', '0').toCharArray(),
        arrayOf('0', '0', '1', '0', '0').toCharArray(),
        arrayOf('0', '0', '0', '1', '1').toCharArray()
    )
    println(岛屿数量().numIslands(grid))
}