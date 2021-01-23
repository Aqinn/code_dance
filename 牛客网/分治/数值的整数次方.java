package 牛客网.分治;

/**
 * @Author Aqinn
 * @Date 2021/1/23 9:21 下午
 */
public class 数值的整数次方 {

    /**
     * 题目描述:
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * <p>
     * 保证base和exponent不同时为0
     */

    public static void main(String[] args) {
        System.out.println(new 数值的整数次方().Power(3, 120));
        System.out.println(7 & 1);
    }

    public double Power(double base, int exponent) {
        boolean flag = exponent < 0;
        double res = 1;
        exponent = flag ? -exponent : exponent;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            exponent >>= 1;
            base *= base;
        }
        return flag ? 1 / res : res;
    }

    public double _Power(double base, int exponent) {
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res = res * base;
        }
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }

}
