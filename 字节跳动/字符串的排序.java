package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/31 12:56 下午
 */
public class 字符串的排序 {

    /**
     * 题目描述:
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
     */

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        //判定
        if (str == null || "".equals(str)) {
            return res;
        }
        // 排序
        char[] arr = str.toCharArray();
        int tail = arr.length - 1;
        sort(arr, tail);
        // 输出
        mix(String.valueOf(arr), "", res);
        return res;
    }

    /**
     * 解析:
     * 弄混的过程，其实就是把后续的字符提到第一位的过程，然后后面的递归调用
     */
    private void mix(String str, String now, ArrayList<String> res) {
        if (str == null) {
            return;
        }
        if ("".equals(str)) {
            if (!res.contains(now)) {
                res.add(now);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            mix(
                    str.substring(0, i) + str.substring(i + 1, str.length()),
                    now + str.charAt(i),
                    res
            );
        }
    }

    private void sort(char[] arr, int len) {
        char[] chars = new char[128];
        for (int i = 0; i <= len; i++) {
            chars[arr[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < 128; i++) {
            while (chars[i]-- > 0) {
                arr[idx++] = (char) i;
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
