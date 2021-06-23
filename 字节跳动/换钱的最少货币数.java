package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/20 11:36 下午
 */
public class 换钱的最少货币数 {

    /**
     * 题目描述:
     * 给定数组 arr，arr 中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个 aim，代表要找的钱数，求组成 aim 的最少货币数。
     * 如果无解，请返回 - 1.
     * <p>
     * 【要求】
     * 时间复杂度O(n×aim)，空间复杂度 O(n)。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45
     */

    public static int minMoney(int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            dp[i] = aim + 1;
        }
        //初始化数组
        dp[0] = 0;
        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j]) {
                    //当前的钱数-当前面值，为之前换过的钱数，如果能够兑换只需要在加+1即可，如果不能就取aim+1;
                    dp[i] = Math.min(dp[i - arr[j]] + 1, dp[i]);
                }
            }
        }
        //对应的总数是否能够兑换取决于是否等于aim+1
        return dp[aim] != aim + 1 ? dp[aim] : -1;
    }

}
