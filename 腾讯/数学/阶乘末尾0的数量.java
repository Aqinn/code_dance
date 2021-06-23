package 腾讯.数学;

/**
 * @Author Aqinn
 * @Date 2021/3/3 1:17 下午
 */
public class 阶乘末尾0的数量 {


    /**
     * 题目描述:
     * 给定一个非负整数 N，返回 N! 结果的末尾为 0 的数量
     * <p>
     * 示例1:
     *  输入
     *      3
     *  输出
     *      0
     *  说明
     *      3!=6
     * <p>
     * 示例2:
     *  输入
     *      5
     *  输出
     *      1
     *  说明
     *      5!=120
     * <p>
     * 示例3:
     *  输入
     *      1000000000
     *  输出
     *      249999998
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/aa03dff18376454c9d2e359163bf44b8
     */

    public long thenumberof0(long n) {
        if (n <= 0) {
            return 0;
        }
        long res = 0;
        while (5 <= n) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }


}