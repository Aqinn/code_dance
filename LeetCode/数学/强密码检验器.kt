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
    // 假设长度大于 20 时，删除需要删除的字符的同时不能帮助未来「6<长度<20」情况减少替换次数时的替换次数
    var modify = 0
    var idx = 0
    val len = pwd.length
    while (idx < len) {
        when {
            lowcase.contains(pwd[idx], false) -> hasLowcase = true
            upcase.contains(pwd[idx], false) -> hasUpcase = true
            digit.contains(pwd[idx], false) -> hasDigit = true
        }
        var count = 1
        while (++idx < len && pwd[idx - 1] == pwd[idx]) {
            count++
        }
        if (count >= 3) {
            when {
                count % 3 == 0 -> tripleN++
                count % 3 == 1 -> tripleN1++
                count % 3 == 2 -> tripleN2++
            }
            modify += count / 3
        }
    }
    val miss = hasLowcase.tf + hasUpcase.tf + hasDigit.tf
    val needDel = len - 20
    return when {
        len < 6 -> {
            max(miss, 6 - len)
        }
        len <= 20 -> {
            max(miss, modify)
        }
        else -> {
            var canDel = needDel
            if (canDel <= tripleN) {
                return max(miss, modify - canDel) + needDel
            }
            canDel -= tripleN
            modify -= tripleN
            if (canDel <= tripleN1 * 2) {
                return max(miss, modify - canDel / 2) + needDel
            }
            canDel -= tripleN1 * 2
            modify -= tripleN1
            max(miss, modify - canDel / 3) + needDel
        }
    }
}

val Boolean.tf
    get() = if (this) 0 else 1

//fun main() {
//    val miss = 缺失的字符类型数量
//    val needDel = 超长的部分，即需要删除字符的次数
//    val modify = 不考虑删除对未来有用的字符，假设删除的所有字符都对未来无用，删除完超出字符个数后还应该替换字符的次数
//    val canDel = 超长的部分，可供删除的字符个数，初始等于 needDel，但注意与 needDel 有区别，接着看后面你就能懂
//    /**
//     * 首先选择把能删的 3n+1连续串 全部删掉是最值的，canDel <= 3n形式连续串数量 是最好的情况
//     * 注意：这个时候被删除了 1 个字符的 3n 连续串会全部转变为 3n+2连续串
//     */
//    if (canDel <= 3n形式连续串数量) {
//        /**
//         * modify - canDel 为优化后剩余的替换字符次数
//         * needDel + (modify - canDel) 意思是删除超出长度部分字符的删除次数，再加上，删除完符合长度条件后，在有优化的情况下需要替换字符的次数
//         * 但如果缺失的字符类型大于 modify - canDel，就必须取应插入的字符类型数量
//         */
//        return needDel + max(modify - canDel, miss)
//    }
//    /**
//     * 上述的情况不满足时，则代表所有 3n连续串 已经消耗完了，但还有可供优化的删除字符次数，这个时候就需要尝试用次优先级的 3n+1连续串 继续探讨优化
//     * 但在这之前，由于前面已经删除了已有的全部 3n连续串，所以需要先考虑已有的优化，canDel 和 modify 的次数要相应减少
//     * 3n连续串 仅需要删除 1 个字符，就可以令后面「6<=长度<=20」情况的替换操作减少1次，所以如下
//     */
//    canDel -= 3n连续串的数量
//    modify -= 3n连续串的数量
//    /**
//     * 与上个操作同理，当下首先选择把能删的 3n+1 连续串全部删掉是最值的
//     * 注意：这个时候被删除了 2 个字符的 3n+1 连续串会全部转变为 3n+2 连续串
//     */
//    if (canDel <= 3n+1连续串的数量 * 2) {
//        /**
//         * 删除的同时亦可减少未来替换操作次数的字符为 canDel 个，由于 2 次删除操作可以为未来减少 1 次替换操作，所以共减少的未来替换操作次数为 canDel/2
//         * 与上同理，也需要考虑缺失的字符类型数量
//         */
//        return needDel + max(modify - canDel / 2, miss)
//    }
//    /**
//     * 全部 3n+1连续串 消耗掉了，也还是有剩下需要删除的字符
//     * 先算上已经消耗掉的 3n+1连续串 的成果，由于 3n+1连续串 的 2 次删除操作可以为未来减少 1 次替换操作，
//     * 所以共减少的未来替换操作次数为 3n+1 连续串 的个数，而未来能提供优化的可删除字符数量也要减去 3n+1连续串 的个数的两倍
//     * 类似于上面的流程，当下仍需要先减去当前已经删除的 3n+1连续串 得到的优化效果
//     */
//    canDel -= tripleN1 * 2
//    modify -= tripleN1
//    /**
//     * 此时所有的连续串都已经变成了 3n+2 的形式，统一了，而 3n+2 连续串是需要删除3个字符才能减少未来的 1 次替换操作，直接除3即可
//     */
//    return max(miss, modify - canDel / 3) + needDel
//}