package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/22 11:31 上午
 */
public class 最长的括号子串 {

    /**
     * 题目描述:
     * 给出一个仅包含字符'(' 和 ')' 的字符串，计算最长的格式正确的括号子串的长度。
     * 对于字符串 "(()" 来说，最长的格式正确的子串是 "()"，长度为 2.
     * 再举一个例子：对于字符串 ")()())", 来说，最长的格式正确的子串是 "()()"，长度为 4.
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/45fd68024a4c4e97a8d6c45fc61dc6ad
     */

    /**
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // dp[i] = 0;
                continue;
            } else if (c == ')') {
                int preIdx = i - dp[i - 1] - 1;
                if (preIdx >= 0 && s.charAt(preIdx) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (preIdx - 1 >= 0) {
                        dp[i] += dp[preIdx - 1];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
