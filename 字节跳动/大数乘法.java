package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/13 11:22 下午
 */
public class 大数乘法 {

    /**
     * 题目描述:
     * 以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
     * （字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c4c488d4d40d4c4e9824c3650f7d5571
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        if (s == null) {
            return t;
        }
        if (t == null) {
            return s;
        }
        if ("0".equals(s) || "0".equals(t)) {
            return "0";
        }
        int[] s1 = new int[s.length()];
        int[] s2 = new int[t.length()];
        int len1 = s1.length, len2 = s2.length;
        for (int i = 0; i < len1; i++) {
            s1[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < len2; i++) {
            s2[i] = t.charAt(i) - '0';
        }
        // 逐位相乘
        int[] res = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                res[i + j] += s1[i] * s2[j];
            }
        }
        // 进位
        int extra = 0;
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            res[i] += extra;
            extra = 0;
            if (res[i] / 10 > 0) {
                extra = res[i] / 10;
                res[i] %= 10;
            }
        }
        int size = len1 + len2;
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            if (res[i] == 0) {
                size--;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (extra != 0) {
            sb.append(extra % 10);
            extra /= 10;
        }
        for (int i = 0; i < size; i++) {
            sb.append((char) (res[i] + (int) '0'));
        }
        return sb.toString();
    }

}
