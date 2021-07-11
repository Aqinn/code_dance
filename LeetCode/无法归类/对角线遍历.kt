package LeetCode.无法归类

import kotlin.math.max
import kotlin.math.min

/**
 * @Author Aqinn
 * @Date 2021/7/11 11:39 下午
 */

/*
题目描述:
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

示例:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出:  [1,2,4,7,5,3,6,8,9]

说明:
给定矩阵中的元素总数不会超过 100000 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diagonal-traverse
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    val rowCount = matrix.size
    if (rowCount == 0) {
        return IntArray(0)
    }
    val colCount = matrix[0].size
    val ans = IntArray(rowCount * colCount)
    var id = 0
    for (i in 0..rowCount + colCount) {
        if (i % 2 == 0) {
            for (r in min(i, rowCount - 1) downTo max(0, i - colCount)) {
                val c = i - r
                if (c in 0 until colCount) {
                    ans[id++] = matrix[r][c]
                }
            }
        } else {
            for (r in max(0, i - colCount)..min(i, rowCount - 1)) {
                val c = i - r
                if (c in 0 until colCount) {
                    ans[id++] = matrix[r][c]
                }
            }
        }
    }
    return ans
}

fun _findDiagonalOrder(mat: Array<IntArray>): IntArray {
    if (mat.isEmpty() || mat[0].isEmpty()) {
        return IntArray(0)
    }
    var i = 0
    var j = 0
    var flag = true
    val res = IntArray(mat.size * mat[0].size)
    var idx = 0
    while (i >= 0 && i < mat.size && j >= 0 && j < mat[i].size) {
        res[idx++] = mat[i][j]
        if (i == 0 || mat[i].size - 1 == j) {
            if (i == 0) {
                j++
            } else {
                i++
            }
            flag = false
            continue
        } else if (j == 0 || mat.size - 1 == i) {
            if (j == 0) {
                j++
            } else {
                i++
            }
            flag = true
            continue
        }
        if (flag) {
            i++
            j++
        } else {
            i--
            j--
        }
    }
    return res
}