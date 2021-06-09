package LeetCode.动态规划

/**
 * @Author Aqinn
 * @Date 2021/6/9 10:46 下午
 */

/**
 * 题目描述:
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 * 给定下面的 5x5 矩阵:
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * 返回:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    if (heights.isEmpty() || heights[0].isEmpty()) {
        return res
    }
    val rows = heights.size
    val cols = heights[0].size
    a = Array(rows) { BooleanArray(cols) }
    b = Array(rows) { BooleanArray(cols) }
    ans = Array(rows) { BooleanArray(cols) }
    for (i in heights.indices) {
        dfs(heights, a, i, 0)
        dfs(heights, b, i, heights[0].size - 1)
    }
    for (i in heights[0].indices) {
        dfs(heights, a, 0, i)
        dfs(heights, b, heights.size - 1, i)
    }
    for (r in heights.indices) {
        for (c in heights[r].indices) {
            if (ans[r][c]) {
                res.add(listOf(r, c))
            }
        }
    }
    return res
}

lateinit var a: Array<BooleanArray>
lateinit var b: Array<BooleanArray>
lateinit var ans: Array<BooleanArray>

fun dfs(arr: Array<IntArray>, visit: Array<BooleanArray>, r: Int, c: Int) {
    if (visit[r][c]) {
        return
    }
    visit[r][c] = true
    if (a[r][c] && b[r][c]) {
        ans[r][c] = true
    }
    if (r > 0 && arr[r - 1][c] >= arr[r][c]) {
        dfs(arr, visit, r - 1, c)
    }
    if (r < arr.size - 1 && arr[r + 1][c] >= arr[r][c]) {
        dfs(arr, visit, r + 1, c)
    }
    if (c > 0 && arr[r][c - 1] >= arr[r][c]) {
        dfs(arr, visit, r, c - 1)
    }
    if (c < arr[r].size - 1 && arr[r][c + 1] >= arr[r][c]) {
        dfs(arr, visit, r, c + 1)
    }
}