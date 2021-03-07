package 快手.动态规划;

/**
 * @Author Aqinn
 * @Date 2021/3/6 11:41 下午
 */
public class 把数字翻译成字符串 {

    /**
     * 题目描述:
     * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
     * 现在给一串数字，返回有多少种可能的译码结果
     */

    public int solve(String nums) {
        if (nums.length() == 0 || nums.charAt(0) == '0')
            return 0;
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            int num = (nums.charAt(i - 1) - '0') * 10 + (nums.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[nums.length() - 1];
    }

    public int _solve(String nums) {
        int len;
        if (nums == null || (len = nums.length()) == 0 || nums.charAt(0) == '0')
            return 0;
        if (len == 1)
            return 1;
        int[] dp = new int[len];
        dp[0] = 1;
        // 长度肯定大于等于2
        for (int i = 1; i < len; i++) {
            char ch1 = nums.charAt(i - 1);
            char ch2 = nums.charAt(i);
            if (ch2 != '0')
                dp[i] = dp[i - 1];
            if (is26(ch1, ch2)) {
                if (i == 1)
                    dp[i]++;
                else
                    dp[i] += dp[i - 2];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }

    private boolean is26(char ch1, char ch2) {
        int x = (ch1 - '0') * 10 + (ch2 - '0');
        return 10 <= x && x <= 26;
    }

}
