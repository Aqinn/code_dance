package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/6/28 10:15 下午
 */

/*
题目描述:
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

示例 2：
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。

示例 3：
输入：digits = [0]
输出：[1]

提示：
1 <= digits.length <= 100
0 <= digits[i] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun plusOne(digits: IntArray): IntArray {
    var remain = 0
    for (i in digits.size - 1 downTo 0) {
        digits[i]++
        digits[i] %= 10
        if (digits[i] != 0) {
            return digits
        }
    }
    return IntArray(digits.size + 1).apply { this[0] = 1 }
}

fun main() {
    println(plusOne(intArrayOf(9)).contentToString())
    println(plusOne(intArrayOf(9, 8)).contentToString())
    println(plusOne(intArrayOf(9, 9)).contentToString())
    println(plusOne(intArrayOf(9, 9, 9)).contentToString())
}