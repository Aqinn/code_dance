package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/6/10 10:44 上午
 */

/**
题目描述:
给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
给你一个有效的甲板，仅由战舰或者空位组成。
战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/battleships-in-a-board
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun countBattleships(board: Array<CharArray>): Int {
    var count = 0
    for (r in board.indices) {
        for (c in board[r].indices) {
            if (!((board[r][c] == '.') || (r > 0 && board[r - 1][c] == 'X') || (c > 0 && board[r][c - 1] == 'X'))) {
                count++
            }
        }
    }
    return count
}