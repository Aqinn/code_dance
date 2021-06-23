package 牛客网.数学;

/**
 * @Author Aqinn
 * @Date 2021/1/27 10:33 下午
 */
public class 从1到n整数中1出现的次数 {

    /**
     * 题目描述:
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     *
     * 来源：牛客
     * 链接：
     */

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += getSum(i);
        }
        return sum;
    }

    private int getSum(int a) {
        int sum = 0;
        while (a / 10 != 0) {
            if (a % 10 == 1) {
                sum++;
            }
            a /= 10;
        }
        if (a == 1) {
            sum++;
        }
        return sum;
    }

}
