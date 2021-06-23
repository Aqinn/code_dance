package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/11 10:25 上午
 */

/**
题目描述:
二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。

给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
小时不会以零开头：
例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
分钟必须由两位数组成，可能会以零开头：
例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-watch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun readBinaryWatch(turnedOn: Int): List<String> {
    if (turnedOn < 0 || turnedOn > 10) {
        return emptyList()
    }
    val res = mutableListOf<String>()
    val hours = intArrayOf(0b1, 0b10, 0b100, 0b1000, 0, 0, 0, 0, 0, 0)
    val mins = intArrayOf(0, 0, 0, 0, 0b1, 0b10, 0b100, 0b1000, 0b10000, 0b100000)
    backtrack(turnedOn, 0, 0, 0, res, hours, mins)
    return res
}

fun backtrack(n: Int, idx: Int, h: Int, m: Int, res: MutableList<String>, hours: IntArray, mins: IntArray) {
    if (h > 11 || m > 59) {
        return
    }
    if (n == 0) {
        res.add(getTime(h, m))
    }
    for (i in idx until 10) {
        backtrack(n - 1, i + 1, h + hours[i], m + mins[i], res, hours, mins)
    }
}

fun getTime(h: Int, m: Int): String {
    return "%d:%02d".format(h, m)
}

fun main() {
    val list = readBinaryWatch(1)
    println(list)
}