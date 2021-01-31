package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/31 11:07 上午
 */
public class 大数加法 {

    /**
     * 题目描述:
     * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
     * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        if (s == null || "".equals(s))
            return t == null ? "" : t;
        if (t == null || "".equals(t))
            return s == null ? "" : s;
        int i = s.length() - 1, j = t.length() - 1;
        int sum = 0, extra = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            sum = extra + getIntFromChar(s.charAt(i)) + getIntFromChar(t.charAt(j));
            extra = 0;
            if (sum > 9) {
                sum %= 10;
                extra = 1;
            }
            sb.append(getCharFromInt(sum));
            i--;
            j--;
        }
        // 处理剩余长度
        while (i >= 0) {
            sum = extra + getIntFromChar(s.charAt(i));
            extra = 0;
            if (sum > 9) {
                sum %= 10;
                extra = 1;
            }
            sb.append(getCharFromInt(sum));
            i--;
        }
        while (j >= 0) {
            sum = extra + getIntFromChar(t.charAt(j));
            extra = 0;
            if (sum > 9) {
                sum %= 10;
                extra = 1;
            }
            sb.append(getCharFromInt(sum));
            j--;
        }
        // 处理剩余加数
        if (extra != 0) {
            sb.append(getCharFromInt(1));
        }
        return sb.reverse().toString();
    }

    private char getCharFromInt(int a) {
        return (char) ('0' + a);
    }

    private int getIntFromChar(char c) {
        if ('0' <= c && c <= '9')
            return c - '0';
        return -1;
    }

}
