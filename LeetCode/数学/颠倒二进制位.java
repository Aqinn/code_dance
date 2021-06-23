package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/25 12:30 下午
 */
public class 颠倒二进制位 {

    /**
     * 题目描述:
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-bits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

}
