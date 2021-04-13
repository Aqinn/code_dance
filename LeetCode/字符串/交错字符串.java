package LeetCode.字符串;

/**
 * @Author Aqinn
 * @Date 2021/3/31 12:04 下午
 */
public class 交错字符串 {

    /**
     * 题目描述:
     * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
     * <p>
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 提示：a + b 意味着字符串 a 和 b 连接。
     * <p>
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * <p>
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     * <p>
     * 输入：s1 = "", s2 = "", s3 = ""
     * 输出：true
     */

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if ("".equals(s1)) {
            return s2.equals(s3);
        }
        if ("".equals(s2)) {
            return s1.equals(s3);
        }
        if ("".equals(s3))
            return false;
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3)
            return false;
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int i=0; i<=l1; i++){
            for(int j=0; j<=l2; j++){
                int p = i+j-1;
                if(i > 0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(p));
                }
                if(j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(p));
                }
            }
        }
        return dp[l1][l2];
    }

    // 超时做法
    private boolean isEnd = false;
    public boolean _isInterleave(String s1, String s2, String s3) {
        if (isEnd) {
            return true;
        }
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if ("".equals(s1)) {
            if (s2.equals(s3))
                isEnd = true;
            return s2.equals(s3);
        }
        if ("".equals(s2)) {
            if (s1.equals(s3))
                isEnd = true;
            return s1.equals(s3);
        }
        if ("".equals(s3))
            return false;
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        if (c1 == c2) {
            if (c1 == c3) {
                return isInterleave(s1.substring(1), s2, s3.substring(1)) ||
                        isInterleave(s1, s2.substring(1), s3.substring(1));
            } else {
                return false;
            }
        } else {
            if (c1 == c3) {
                return isInterleave(s1.substring(1), s2, s3.substring(1));
            } else if (c2 == c3) {
                return isInterleave(s1, s2.substring(1), s3.substring(1));
            } else {
                return false;
            }
        }
    }

}
