package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/3/21 9:10 下午
 */
public class 字符串变形 {

    /**
     * 题目描述:
     * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。
     * 首先这个字符串中包含着一些空格，就像"Hello World"一样，
     * 然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
     * 比如"Hello World"变形后就变成了"wORLD hELLO"。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e
     */

    public static void main(String[] args) {
        字符串变形 main = new 字符串变形();
        System.out.println(main.trans("wORLD hELLO", 11));
    }

    public String trans(String s, int n) {
        if (s == null) {
            return "";
        }
        char[] arr = s.toCharArray();
        revert(arr, 0, n - 1);
        int i = 0, j = 0;
        while (i < n) {
            // 找到第一个非空格符号
            while (i < n && arr[i] == ' ') {
                i++;
            }
            // 找到 i 后面的第一个空格
            j = i + 1;
            while (j < n && arr[j] != ' ') {
                j++;
            }
            revert(arr, i, j - 1);
            i = j + 1;
        }
        for (int k = 0; k < n; k++) {
            arr[k] = switchChar(arr[k]);
        }
        return String.valueOf(arr);
    }

    private void revert(char[] arr, int l, int r) {
        int len = (l + r) / 2;
        for (int i = l; i <= len; i++) {
            swapAndSwitch(arr, i, r - (i - l));
        }
    }

    private void swapAndSwitch(char[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    private char switchChar(char ch) {
        if ('A' <= ch && ch <= 'Z') {
            return (char) (ch + 32);
        } else if ('a' <= ch && ch <= 'z') {
            return (char) (ch - 32);
        } else {
            return ch;
        }
    }


}
