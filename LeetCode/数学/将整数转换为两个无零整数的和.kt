package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/7/10 11:35 下午
 */

/*
题目描述:
「无零整数」是十进制表示中 不含任何 0 的正整数。
给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
A 和 B 都是无零整数
A + B = n
题目数据保证至少有一个有效的解决方案。
如果存在多个有效解决方案，你可以返回其中任意一个。

示例 1：
输入：n = 2
输出：[1,1]
解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。

示例 2：
输入：n = 11
输出：[2,9]

示例 3：
输入：n = 10000
输出：[1,9999]

示例 4：
输入：n = 69
输出：[1,68]

示例 5：
输入：n = 1010
输出：[11,999]

提示：
2 <= n <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun getNoZeroIntegers(n: Int): IntArray {
    val res = IntArray(2)
    for (i in 1 until n) {
        if (!i.toString().contains('0', false)
            && !(n - i).toString().contains('0', false)
        ) {
            res[0] = i
            res[1] = n - i
        }
    }
    return res
}