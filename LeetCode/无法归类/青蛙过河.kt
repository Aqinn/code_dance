package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/6/14 2:13 下午
 */

/**
题目描述:
一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。
青蛙可以跳上石子，但是不可以跳入水中。
给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。
另请注意，青蛙只能向前方（终点的方向）跳跃。

示例 1：
输入：stones = [0,1,3,5,6,8,12,17]
输出：true
解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。

示例 2：
输入：stones = [0,1,2,3,4,8,9,11]
输出：false
解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/frog-jump
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 解法一
fun _canCross(stones: IntArray): Boolean {
    if (stones.size < 2 || stones[0] != 0 || stones[1] != 1) {
        return false
    }
    // 辅助搜索石子
    val map = HashMap<Int, Int>()
    stones.mapIndexed { index, i -> map.put(i, index) }
    val memo: Array<MutableList<Boolean?>> = Array(stones.size) { mutableListOf<Boolean?>() }
    memo.map {
        for (i in stones.indices) {
            // null 代表没有以该跳跃距离到过该石子
            // true 代表之前已经以该跳跃距离到过该石子，并且最终可以到达最后一个石子
            // false 代表之前已经以该跳跃距离到过该石子，但最终并不可以到达最后一个石子
            it.add(null)
        }
    }
    return dfs(stones, map, 0, 0, memo)
}

fun dfs(
    stones: IntArray,
    map: HashMap<Int, Int>,
    step: Int,
    idx: Int,
    memo: Array<MutableList<Boolean?>>
): Boolean {
    if (idx == stones.size - 1) {
        return true
    }
    // 如果为 null，说明还没到以该跳跃距离到过该石子
    // 如果不为 null，直接输出之前的结果
    memo[idx][step]?.let {
        return it
    }
    for (cur in step - 1..step + 1) {
        if (cur > 0) {
            if (map.containsKey(stones[idx] + cur) && dfs(stones, map, cur, map[stones[idx] + cur]!!, memo)) {
                memo[idx][step] = true
                return true
            }
        }
    }
    memo[idx][step] = false
    return false
}

// 解法二
fun canCross(stones: IntArray): Boolean {
    if (stones.size < 2 || stones[0] != 0 || stones[1] != 1) {
        return false
    }
    // dp[i][k] 表示青蛙能否以跳跃距离 j 到达 石子 i
    val dp = Array(stones.size) { BooleanArray(stones.size) }
    dp[0][0] = true
    for (i in 1 until stones.size) {
        if (stones[i] - stones[i - 1] > i) {
            return false
        }
    }
    for (i in stones.indices) {
        for (j in i - 1 downTo 0) {
            val k = stones[i] - stones[j]
            if (k > j + 1) {
                break
            }
            dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1]
            if (i == stones.size - 1 && dp[i][k]) {
                return true
            }
        }
    }
    return false
}

fun main() {
    println(canCross(intArrayOf(0, 1, 3, 5, 6, 8, 12, 17)))
}