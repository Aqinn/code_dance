package LeetCode.动态规划

/**
 * @Author Aqinn
 * @Date 2021/6/17 3:27 下午
 */

/**
题目描述:
给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
返回一个数组 [r1, c1, r2, c2]，
其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。
若有多个满足条件的子矩阵，返回任意一个均可。

说明：
1 <= matrix.length, matrix[0].length <= 200

示例：
输入：
[
[-1,0],
[0,-1]
]
输出：[0,1,0,1]
解释：输入中标粗的元素即为输出所表示的矩阵

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-submatrix-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun getMaxMatrix(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return IntArray(0)
    }
    // 保存答案 [r1,c1,r2,c2]
    val res = IntArray(4)
    var max = Int.MIN_VALUE
    for (i in matrix.indices) {
        val sumArr = IntArray(matrix[i].size)
        for (j in i until matrix.size) {
            for (col in matrix[j].indices) {
                sumArr[col] += matrix[j][col]
            }
            var base = 0
            var begin = 0
            var tempSum = Int.MIN_VALUE
            for (sumArrIdx in sumArr.indices) {
                if (base >= 0) {
                    base += sumArr[sumArrIdx]
                } else {
                    base = sumArr[sumArrIdx]
                    begin = sumArrIdx
                }
                tempSum = if (tempSum > base) tempSum else base
                if (tempSum > max) {
                    max = tempSum
                    res[0] = i
                    res[1] = begin
                    res[2] = j
                    res[3] = sumArrIdx
                }
            }
        }
    }
    return res
}