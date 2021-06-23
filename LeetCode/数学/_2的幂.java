package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/29 12:14 下午
 */
public class _2的幂 {

    /**
     * 题目描述:
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-of-two
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

}
