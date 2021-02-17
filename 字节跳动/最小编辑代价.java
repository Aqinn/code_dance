package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/17 1:54 下午
 */
public class 最小编辑代价 {

    /**
     * 题目描述:
     * 给定两个字符串 str1 和 str2，再给定三个整数 ic，dc 和 rc，分别代表插入、删除和替换一个字符的代价，
     * 请输出将 str1 编辑成 str2 的最小代价。
     */

    /**
     * min edit cost
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic   int整型 insert cost
     * @param dc   int整型 delete cost
     * @param rc   int整型 replace cost
     * @return int整型
     */
    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i * dc;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i * ic;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + ic;
                    int delete = dp[i - 1][j] + dc;
                    int replace = dp[i - 1][j - 1] + rc;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }

}
