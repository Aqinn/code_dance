package LeetCode.动态规划;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/1/24 9:39 下午
 */
public class 最长不含重复字符的子字符串 {

    // cost time => 16:34

    /**
     * 题目描述:
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     * s.length <= 40000
     * <p>
     * 输入: "abcabcbb"
     * <p>
     * 输出: 3
     * <p>
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        最长不含重复字符的子字符串 main = new 最长不含重复字符的子字符串();
        System.out.println(main.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        // dp[i] 以 s.chatAt(i) 结尾的最长不重复子串长度
        // 状态转移方程 判断 i 是否与 前面dp[i-1] 个字符重复，不重复则 dp[i] = 1 + dp[i-1]，否则为 1 + 往前搜索时最长不重复的子串的长度
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < s.length(); i++) {
            boolean flag = true;
            for (int j = i - 1, size = 0; size < dp[i - 1]; j--, size++) {
                if (s.charAt(j) == s.charAt(i)) {
                    flag = false;
                    dp[i] = 1 + size;
                    break;
                }
            }
            if (flag) {
                dp[i] = 1 + dp[i - 1];
                if (dp[i] > max)
                    max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

}
