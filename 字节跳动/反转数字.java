package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/18 12:09 下午
 */
public class 反转数字 {

    /**
     * 题目描述:
     * 将给出的 32 位整数 x 翻转。
     * 例 1:x=123，返回 321
     * 例 2:x=-123，返回 - 321
     * <p>
     * 你有注意到翻转后的整数可能溢出吗？因为给出的是 32 位整数，则其数值范围为[−2^{31}, 2^{31} − 1][−2^31,2^31−1]。
     * 翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/1a3de8b83d12437aa05694b90e02f47a
     */

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        boolean flag = x > 0;
        if (!flag) {
            sb = new StringBuilder(sb.substring(1));
        }
        if (isOut(sb.reverse().toString(), flag)) {
            return 0;
        }
        return (flag ? 1 : -1) * Integer.parseInt(sb.toString());
    }

    private boolean isOut(String str, boolean flag) {
        String max = String.valueOf(Integer.MAX_VALUE);
        // 负数
        if (!flag) {
            max = String.valueOf(Integer.MIN_VALUE);
            max = max.substring(1);
        }
        if (str.length() < max.length()) {
            return false;
        }
        if (str.length() > max.length()) {
            return true;
        }
        for (int i = max.length() - 1; i >= 0; i--) {
            if (!compareCharInt(str.charAt(i), max.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean compareCharInt(char a, char b) {
        return (a - '0') <= (b - '0');
    }

}
