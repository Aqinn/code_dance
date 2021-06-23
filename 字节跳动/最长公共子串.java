package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 11:41 下午
 */
public class 最长公共子串 {

    /**
     * 题目描述:
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac
     */

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        if (str1 == null || "".equals(str1)) {
            return "-1";
        }
        if (str2 == null || "".equals(str2)) {
            return "-1";
        }
        // dp[i][j] 以str1.i结尾的与str2.j结尾的最长公共子串
        // dp[i][j] = (ch1 == ch2) ? dp[i-1][j-1] + 1 : 0
        int s1L = str1.length(), s2L = str2.length();
        int[][] dp = new int[s1L][s2L];
        int max = Integer.MIN_VALUE;
        int maxStr = -1;
        for (int i = 0; i < s1L; i++) {
            char ch1 = str1.charAt(i);
            for (int j = 0; j < s2L; j++) {
                char ch2 = str2.charAt(j);
                if (ch1 == ch2) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        maxStr = i;
                    }
                }
            }
        }
        return maxStr == -1 ? "-1" : str1.substring(maxStr + 1 - max, maxStr + 1);
    }

}
