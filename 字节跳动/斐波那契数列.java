package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/31 1:22 下午
 */
public class 斐波那契数列 {

    /**
     * 题目描述:
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n<=39
     */

    public int Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int pre = 1, prepre = 0, temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = pre + prepre;
            prepre = pre;
            pre = temp;
        }
        return temp;
    }

}
