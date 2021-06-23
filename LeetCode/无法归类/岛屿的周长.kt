package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/6/18 11:22 下午
 */

/**
题目描述:
给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

示例 1：
输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
输出：16
解释：它的周长是上面图片中的 16 个黄色的边

示例 2：
输入：grid = [[1]]
输出：4

示例 3：
输入：grid = [[1,0]]
输出：4

提示：
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] 为 0 或 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/island-perimeter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun islandPerimeter(grid: Array<IntArray>): Int {
    val n = grid.size
    var res = 0
    for (i in 0 until n) {
        val m: Int = grid[i].size
        for (j in 0 until m) {
            if (grid[i][j] == 1) {
                // 上
                if (i == 0 || grid[i - 1][j] == 0) {
                    res += 1
                }
                // 左
                if (j == 0 || grid[i][j - 1] == 0) {
                    res += 1
                }
                // 下
                if (i == n - 1 || grid[i + 1][j] == 0) {
                    res += 1
                }
                // 右
                if (j == m - 1 || grid[i][j + 1] == 0) {
                    res += 1
                }
            }
        }
    }
    return res
}

fun _islandPerimeter(grid: Array<IntArray>): Int {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val n = grid.size
    val m: Int = grid[0].size
    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (grid[i][j] == 1) {
                var cnt = 0
                for (k in 0..3) {
                    val tx = i + dx[k]
                    val ty = j + dy[k]
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                        cnt += 1
                    }
                }
                ans += cnt
            }
        }
    }
    return ans
}

