package LeetCode.字符串

/**
 * @Author Aqinn
 * @Date 2021/6/27 9:42 下午
 */

/*
题目描述:
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"

示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I

示例 3：
输入：s = "A", numRows = 1
输出："A"

提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun convert(s: String, numRows: Int): String {
    val sbArr = Array<StringBuilder>(numRows) { StringBuilder() }
    var idx = 0
    var flag = true
    for (ch in s) {
        sbArr[idx].append(ch)
        if (flag) {
            if (idx < numRows - 1) {
                idx++
            } else {
                if (numRows != 1) {
                    idx--
                    flag = !flag
                }
            }
        } else {
            if (idx > 0) {
                idx--
            } else {
                if (numRows != 1) {
                    idx++
                    flag = !flag
                }
            }
        }
    }
    val res = StringBuilder()
    sbArr.forEach { res.append(it.toString()) }
    return res.toString()
}