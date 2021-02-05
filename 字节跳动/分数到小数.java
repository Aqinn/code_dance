package 字节跳动;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/2/5 10:37 下午
 */
public class 分数到小数 {

    /**
     * 题目描述:
     * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
     * 如果小数部分为循环小数，则将循环的部分括在括号内。
     * 如果存在多个答案，只需返回 任意一个 。
     * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
     */

    public static void main(String[] args) {
        分数到小数 main = new 分数到小数();
        System.out.println(main.fractionToDecimal(11515, 10000));
        StringBuilder sb = new StringBuilder("12345");
        sb.insert(3, 0);
        System.out.println(sb.toString());
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 || denominator < 0)
            sb.append("-");
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0){
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return sb.toString();
    }

}
