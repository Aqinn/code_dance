package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/8 6:58 上午
 */
class 岛屿数量 {

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