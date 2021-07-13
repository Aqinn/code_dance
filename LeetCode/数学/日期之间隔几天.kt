package code_dance.LeetCode.数学

/*
题目描述:
请你编写一个程序来计算两个日期之间隔了多少天。
日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。

示例 1：
输入：date1 = "2019-06-29", date2 = "2019-06-30"
输出：1

示例 2：
输入：date1 = "2020-01-15", date2 = "2019-12-31"
输出：15

提示：
给定的日期是 1971 年到 2100 年之间的有效日期。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-days-between-two-dates
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    //区分平年闰年月份和年份天数
    private val Month = arrayOf(intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31), intArrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31))
    private val Day = intArrayOf(365, 366)

    //计算两个日期分别与1971.01.01日的差，之后再做差取绝对值即可
    fun daysBetweenDates(date1: String, date2: String): Int {
        val d1 = date1.split("-".toRegex()).toTypedArray()
        val d2 = date2.split("-".toRegex()).toTypedArray()
        val year1 = Integer.valueOf(d1[0])
        val year2 = Integer.valueOf(d2[0])
        val month1 = Integer.valueOf(d1[1])
        val month2 = Integer.valueOf(d2[1])
        val day1 = Integer.valueOf(d1[2])
        val day2 = Integer.valueOf(d2[2])
        val s1 = gap(year1, month1, day1)
        val s2 = gap(year2, month2, day2)
        return Math.abs(s1 - s2)
    }

    //计算一个日期与1971.01.01日的日期差
    fun gap(year: Int, month: Int, day: Int): Int {
        var sum = 0
        val flag = isleapyear(year)
        for (i in 1971 until year) {
            sum += Day[isleapyear(i)]
        }
        for (i in 1 until month) {
            sum += Month[flag][i]
        }
        sum += day
        return sum
    }

    //判断是否闰年
    fun isleapyear(year: Int): Int {
        return if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1 else 0
    }
}
