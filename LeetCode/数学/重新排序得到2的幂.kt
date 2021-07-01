package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/7/1 4:38 下午
 */

/*
题目描述:
给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。

示例 1：
输入：1
输出：true

示例 2：
输入：10
输出：false

示例 3：
输入：16
输出：true

示例 4：
输入：24
输出：false

示例 5：
输入：46
输出：true

提示：
1 <= N <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reordered-power-of-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun reorderedPowerOf2(n: Int): Boolean {
    if (n <= 0) {
        return false
    }
    val base = count(n)
    var x = 1
    for (i in 1..31) {
        if (base.contentEquals(count(x))) {
            return true
        }
        x = x shl 1
    }
    return false
}

fun count(n: Int): IntArray {
    val res = IntArray(10)
    var temp = n
    while (temp != 0) {
        res[temp % 10]++
        temp /= 10
    }
    return res
}