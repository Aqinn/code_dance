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

    // 待完善
    public int _solve(String nums) {
        int len;
        if (nums == null || (len = nums.length()) == 0)
            return 0;
        if (len == 1)
            return 1;
        int[] dp = new int[len + 2];
        dp[0] = 1;
        // 长度肯定大于等于2
        if (low2(nums.charAt(0)) && low6(nums.charAt(1))) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < len; i++) {
            char ch1 = nums.charAt(i - 1);
            char ch2 = nums.charAt(i);
            if (low2(ch1) && low6(ch2)) {
                dp[i] = dp[i - 1] + dp[i - 2] + 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + 1;
            }
        }
        return dp[len - 1];
    }

    private boolean low2(char c) {
        return '0' <= c && c <= '2';
    }

    private boolean low6(char c) {
        return '0' <= c && c <= '6';
    }

}
