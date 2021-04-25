package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/25 12:30 下午
 */
public class 颠倒二进制位 {

    /**
     * 题目描述:
     * 颠倒给定的 32 位无符号整数的二进制位。
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
