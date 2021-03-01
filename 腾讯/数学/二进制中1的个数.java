package 腾讯.数学;

/**
 * @Author Aqinn
 * @Date 2021/3/1 10:23 下午
 */
public class 二进制中1的个数 {

    /**
     * 题目描述:
     * 输入一个整数，输出该数 32 位二进制表示中 1 的个数。其中负数用补码表示。
     */

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

}