package 面试算法题;

/**
 * @Author Aqinn
 * @Date 2021/1/28 10:03 下午
 */
public class _36进制加法 {

    /**
     * 题目描述:
     * <p>
     * 36进制由0-9，a-z，共36个字符表示，最小为'0'
     * '0''9'对应十进制的09，'a''z'对应十进制的1035
     * 例如：'1b' 换算成10进制等于 1 * 36^1 + 11 * 36^0 = 36 + 11 = 47
     * 要求按照加法规则计算出任意两个36进制正整数的和
     * 如：按照加法规则，计算'1b' + '2x' = '48'
     * <p>
     * 要求：不允许把36进制数字整体转为10进制数字，计算出10进制数字的相加结果再转回为36进制
     **/

    public static void main(String[] args) {
        System.out.println(new _36进制加法().add("1b", "2x"));
    }

    public String add(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        if ("".equals(a)) {
            return b;
        }
        if ("".equals(b)) {
            return a;
        }
        int size = a.length() < b.length() ? a.length() - 1 : b.length() - 1;
        int p = 0;
        StringBuilder sb = new StringBuilder("");
        String symbol = "0123456789abcdefghijklmnopqrstuvwxyz";
        int temp = 0;
        int extra = 0;
        while (p <= size) {
            temp = getIntFromChar(a.charAt(a.length() - 1 - p)) + getIntFromChar(b.charAt(b.length() - 1 - p)) + extra;
            extra = 0;
            if (temp >= 36) {
                temp -= 36;
                extra = 1;
            }
            sb.append(symbol.charAt(temp));
            p++;
        }
        if (p == a.length()) {
            while (p <= b.length() - 1) {
                sb.append(b.charAt(b.length() - 1 - p));
                p++;
            }
        } else {
            while (p <= a.length() - 1) {
                sb.append(a.charAt(a.length() - 1 - p));
                p++;
            }
        }
        return sb.reverse().toString();
    }

    private int getIntFromChar(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        if ('a' <= c && c <= 'z') {
            return c - 'a' + 10;
        }
        if ('A' <= c && c <= 'Z') {
            return c - 'A' + 10;
        }
        return 0;
    }

}
