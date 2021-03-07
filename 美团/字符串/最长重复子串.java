package 美团.字符串;

/**
 * @Author Aqinn
 * @Date 2021/3/7 10:18 下午
 */
public class 最长重复子串 {

    /**
     * 题目描述:
     * 一个重复字符串是由两个相同的字符串首尾拼接而成，例如abcabc便是长度为6的一个重复字符串，而abcba则不存在重复字符串。
     * 给定一个字符串，请编写一个函数，返回其最长的重复字符子串。
     * 若不存在任何重复字符子串，则返回0。
     * <p>
     * 示例输入:
     * "ababc"
     * <p>
     * 示例输出:
     * 4
     * <p>
     * 说明:
     * abab为最长的重复字符子串，长度为4
     */

    public int solve(String a) {
        int len;
        if (a == null || (len = a.length()) == 0 || len == 1)
            return 0;
        int max = len / 2;
        for (int i = max; i >= 0; i--) {
            for (int j = 0; j <= len - i * 2; j++) {
                if (isRepeat(a, j, i)) {
                    return i * 2;
                }
            }
        }
        return 0;
    }

    private boolean isRepeat(String str, int start, int size) {
        for (int i = start; i < start + size; i++) {
            if (str.charAt(i) != str.charAt(i + size)) {
                return false;
            }
        }
        return true;
    }

}
