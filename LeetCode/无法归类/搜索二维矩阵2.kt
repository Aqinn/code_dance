package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/11 10:31 上午
 */
class 搜索二维矩阵2 {

    /**
     * 题目描述:
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty())
            return false
        var r = 0
        var c = matrix[0].size - 1
        while (r < matrix.size && c >= 0) {
            when {
                matrix[r][c] == target -> return true
                matrix[r][c] < target -> r += 1
                matrix[r][c] > target -> c -= 1
            }
        }
        return false
    }

}