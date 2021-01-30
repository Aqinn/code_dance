package 牛客网.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/1/30 1:48 下午
 */
public class 最长公共子序列 {

    /**
     * 题目描述:
     * 给定两个字符串 str1 和 str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出 - 1。
     */


    public String LCS (String s1, String s2) {
        // dp[i][j] s1[0:i],s2[0:j] 的最长公共子序列
        // dp[i][0]=0 dp[0][j]=0
        // 状态转移 s1[i]==s2[j] dp[i][j]=dp[i-1][j-1] + 1
        //        s1[i]!=s2[j] dp[i][j] = Math.max(dp[i-1][j], dp[i][j])
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        if (dp[s1.length()-1][s2.length()-1] == 0)
            return "-1";
        StringBuilder sb = new StringBuilder();
        int i=s1.length(), j=s2.length();
        while(i>0 && j>0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i][j-1] > dp[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        return sb.reverse().toString();
    }

}
