package LeetCode.无法归类;

/**
 * @Author Aqinn
 * @Date 2021/3/26 2:14 下午
 */
public class 外观数列 {

    /**
     * 题目描述:
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     */

    public static void main(String[] args) {
        外观数列 main = new 外观数列();
        System.out.println(main.countAndSay(1));
        System.out.println(main.countAndSay(2));
        System.out.println(main.countAndSay(3));
        System.out.println(main.countAndSay(4));
        System.out.println(main.countAndSay(5));
    }

    public String countAndSay(int n) {
        return solve("1", n);
    }

    private String solve(String str, int n) {
        if (str == null)
            str = "1";
        int len = str.length();
        if (n <= 1)
            return str;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (i + 1 < len) {
                char next = str.charAt(i + 1);
                if (ch == next) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(ch);
                    count = 1;
                }
            } else {
                sb.append(count);
                sb.append(ch);
            }
        }
        return solve(sb.toString(), n - 1);
    }

}
