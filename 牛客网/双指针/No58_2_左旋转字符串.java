package 牛客网.双指针;

/**
 * @Author Aqinn
 * @Date 2021/1/21 5:54 下午
 */
public class No58_2_左旋转字符串 {

    /**
     * 题目描述:
     * 将字符串 S 从第 K 位置分隔成两个子字符串，并交换这两个子字符串的位置。
     */

    public static void main(String[] args) {
        No58_2_左旋转字符串 main = new No58_2_左旋转字符串();
        String reverse = main.LeftRotateString("abcdefg", 7);
        System.out.println(reverse);
    }

    public String LeftRotateString(String str, int n) {
        if (n > str.length())
            return "";
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        System.out.println(chars);
        reverse(chars, n, chars.length - 1);
        System.out.println(chars);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        if (begin >= end)
            return;
        for (int i = begin; i <= (begin + end) / 2; i++) {
            swap(chars, i, end - i + begin);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
