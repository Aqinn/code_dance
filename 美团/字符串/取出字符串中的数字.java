package 美团.字符串;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Aqinn
 * @Date 2021/3/13 11:25 下午
 */
public class 取出字符串中的数字 {

    /**
     * 2021 春招 美团笔试第二题
     * 题目描述:
     * 如题
     * <p>
     * 示例输入:
     * He15l154lo87wor7l87d
     * <p>
     * 示例输出:
     * 7
     * 15
     * 87
     * 87
     * 154
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        List<String> res = getNumber(str);
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;
                int len = o1.length();
                for (int i = 0; i < len; i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    int i1 = getDigit(c1);
                    int i2 = getDigit(c2);
                    if (i1 > i2) {
                        return 1;
                    } else if (i1 < i2) {
                        return -1;
                    }
                }
                return 0;
            }
        });
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static List<String> getNumber(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || "".equals(str))
            return res;
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    res.add(removeZero(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            res.add(removeZero(sb.toString()));
        }
        return res;
    }

    private static String removeZero(String str) {
        int i = 0;
        int len = str.length();
        for (int j = 0; j < len; j++) {
            if (str.charAt(i) == '0')
                i++;
            else break;
        }
        if (i == len)
            return "0";
        return str.substring(i);
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static int getDigit(char c) {
        return c - '0';
    }

}
