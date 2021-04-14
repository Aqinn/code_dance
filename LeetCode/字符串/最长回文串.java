package LeetCode.字符串;

/**
 * @Author Aqinn
 * @Date 2021/4/14 8:03 下午
 */
public class 最长回文串 {

    /**
     * 题目描述:
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * <p>
     * 输入:
     * "abccccdd"
     * <p>
     * 输出:
     * 7
     * <p>
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */

    /**
     * 对于每一个字符出现的次数进行统计
     * 双数次数的字符，次数直接加起来到结果中
     * 单数次数的字符，取其减1，并且当结果为双数时可以再为结果+1
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}
