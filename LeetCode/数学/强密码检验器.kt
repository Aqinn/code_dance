package LeetCode.数学

import kotlin.math.max

/**
 * @Author Aqinn
 * @Date 2021/6/13 2:46 下午
 */

/**
 * 题目描述:
 * 一个强密码应满足以下所有条件：
 *
 * 由至少6个，至多20个字符组成。
 * 至少包含一个小写字母，一个大写字母，和一个数字。
 * 同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
 * 编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。
 *
 * 插入、删除、替换任一字符都算作一次修改。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strong-password-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun strongPasswordChecker(pwd: String): Int {
    val lowcase = "qwertyuiopasdfghjklzxcvbnm"
    val upcase = "QWERTYUIOPASDFGHJKLZXCVBNM"
    val digit = "0123456789"
    var hasLowcase = false
    var hasUpcase = false
    var hasDigit = false
    // 形式为 3n 的连续串个数
    var tripleN = 0
    // 形式为 3n+1 的连续串个数
    var tripleN1 = 0
    // 形式为 3n+2 的连续串个数
    var tripleN2 = 0
    // 中间变量，用于统计连续串
    var count = 0
    // 假设长度大于 20 时，需要删除字符时不能帮助减少替换次数时的替换次数
    var modify = 0
    for (idx in pwd.indices) {
        when {
            lowcase.contains(pwd[idx], false) -> hasLowcase = true
            upcase.contains(pwd[idx], false) -> hasUpcase = true
            digit.contains(pwd[idx], false) -> hasDigit = true
        }
        val flag = idx == 0 || pwd[idx - 1] == pwd[idx]
        if (flag) {
            count++
        }
        if (!flag || idx == pwd.length - 1) {
            if (count >= 3) {
                when {
                    count % 3 == 0 -> tripleN++
                    count % 3 == 1 -> tripleN1++
                    count % 3 == 2 -> tripleN2++
                }
                modify += count / 3
            }
            count = 1
        }
    }
    var miss = 0
    if (!hasLowcase) {
        miss++
    }
    if (!hasUpcase) {
        miss++
    }
    if (!hasDigit) {
        miss++
    }
    return when {
        pwd.length < 6 -> {
            max(miss, 6 - pwd.length)
        }
        pwd.length <= 20 -> {
            max(miss, modify)
        }
        else -> {
            var canDel = pwd.length - 20
            /**
             * 3n 连续串数量 > 可供删除的字符
             * 这个时候选择把能删的 3n 连续串全部删掉是最值的
             */
            if (canDel < tripleN) {
                return max(miss, modify - canDel) + pwd.length - 20
            }
            /**
             * 3n 连续串数量 <= 可供删除的字符
             * 注意：这个时候被删除了 1 个字符的 3n 连续串已经全部转变为 3n+2 连续串
             * 这个时候选择把能删的 3n+1 连续串全部删掉是最值的
             * 由于前面已经删除过 3n 连续串，所以这个时候需要删除对应个 canDel modify 操作
             */
            canDel -= tripleN
            modify -= tripleN
            if (canDel < tripleN1 * 2) {
                return max(miss, modify - canDel / 2) + pwd.length - 20
            }
            /**
             * 3n+1 连续串数量 <= 可供删除的字符
             * 注意：这个时候被删除了 2 个字符的 3n+1 连续串已经全部转变为 3n+2 连续串，综上，此时剩下的连续串全都是 3n+2 形式的
             * 由于前面已经删除过 3n+1 连续串，所以这个时候需要删除对应个 canDel modify 操作，删除 2 个 3n+1 连续串的字符可以减少未来 1 次修改的次数
             */
            canDel -= tripleN1 * 2
            modify -= tripleN1
            max(miss, modify - canDel / 3) + pwd.length - 20
        }
    }
}