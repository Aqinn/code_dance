package 牛客网.搜索;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author Aqinn
 * @Date 2021/1/24 2:12 上午
 */
public class 字符串的排列 {

    /**
     * 题目描述:
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */

    public static void main(String[] args) {
        字符串的排列 main = new 字符串的排列();
        ArrayList<String> list = main.Permutation("abb");
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0)
            return result;
        char[] temp = new char[128];
        for (int i = 0; i < str.length(); i++) {
            temp[str.charAt(i)]++;
        }
        char[] chars = new char[str.length()];
        int count = 0;
        for (int i = 0; i < 128; i++) {
            if (temp[i]-- > 0) {
                chars[count++] = (char) i;
                --i;
            }
        }
        str = String.valueOf(chars);
        recur(str, "", result);
        return result;
    }

    private void recur(String str, String cur, ArrayList<String> result) {
        if (str.length() == 0) {
            if (!result.contains(cur)) {
                result.add(cur);
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                recur(str.substring(0, i) + str.substring(i + 1), cur + str.charAt(i), result);
            }
        }
    }


}
