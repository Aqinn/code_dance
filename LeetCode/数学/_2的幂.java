package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/29 12:14 下午
 */
public class _2的幂 {

    /**
     * 题目描述:
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     */

    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        while (n != 1) {
            if (n % 2 == 0)
                n /= 2;
            else
                return false;
        }
        return true;
    }

}
