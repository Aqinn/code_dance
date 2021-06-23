package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/4/30 10:30 上午
 */
class 各位相加 {

    /**
     * 题目描述:
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 461 可以分解成 4*100 + 6*10 + 1*1
     * 还可以继续分解成
     * 4*(1+99) + 6*(1+9) + 1*1
     * 4*99 + 6*99 + 4 + 6 + 1
     * 这样可以将 4、6、1 分离出来 => 4 + 6 + 1 = 11
     * 对 11 也重复上述操作可得 2
     * 显而易见，这样的做法就是原数对 9 取模 => 461 % 9 = 2
     * 这题还要再考虑 18 这样的特殊情况，9 的倍数最终所得结果应该是 9
     * 但是最终得到的却是 0
     * 解决办法就是 (x-1) % 9 + 1
     * 完。
     */
    fun addDigits(num: Int): Int {
        if (num <= 0)
            return 0;
        return (num - 1) % 9 + 1;
    }

}

fun main() {
    val main = 各位相加()
    println(main.addDigits(18))
}