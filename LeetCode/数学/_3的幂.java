package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/9 11:45 下午
 */
public class _3的幂 {

    /**
     * 题目描述:
     * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     */

    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }

    // 更快的解法
    public boolean _isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
