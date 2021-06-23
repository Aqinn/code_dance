package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/5 12:06 下午
 */
class 托普利茨矩阵 {

    /**
     * 题目描述:
     * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
     * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 直接让每个元素与其左上角的元素比较，不一样就返回false即可
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty())
            return false
        val rowLen = matrix.size
        val colLen = matrix[0].size
        for (i in 1 until rowLen) {
            for (j in 1 until colLen) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false
            }
        }
        return true
    }

    fun _isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty())
            return false
        val rowLen = matrix.size
        val colLen = matrix[0].size
        for (i in 0 until rowLen) {
            if (!isDiagonalLineValueSame(matrix, i, 0)) {
                return false
            }
        }
        for (i in 1 until colLen) {
            if (!isDiagonalLineValueSame(matrix, 0, i)) {
                return false
            }
        }
        return true
    }

    fun isDiagonalLineValueSame(matrix: Array<IntArray>, row: Int, col: Int): Boolean {
        if (row >= matrix.size || col >= matrix[row].size) {
            return false
        }
        val num = matrix[row][col]
        var r = row + 1
        var c = col + 1
        while (r < matrix.size && c < matrix[r].size) {
            if (matrix[r][c] != num)
                return false
            r += 1
            c += 1
        }
        return true
    }

}