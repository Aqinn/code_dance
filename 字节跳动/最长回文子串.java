package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 9:40 上午
 */
public class 最长回文子串 {

    /**
     * 题目描述:
     * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
     * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
     */

    public int getLongestPalindrome(String A, int n) {
        if (A == null || n <= 0)
            return 0;
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1) {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                        maxLen = maxLen > 2 ? maxLen : 2;
                    }
                } else {
                    if (A.charAt(i) == A.charAt(j) &&
                            dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        maxLen = maxLen > (i - j + 1) ? maxLen : (i - j + 1);
                    }
                }
            }
        }
        return maxLen;
    }

}
