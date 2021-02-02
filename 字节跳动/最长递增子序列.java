package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/2 10:23 下午
 */
public class 最长递增子序列 {

    /**
     * 题目描述:
     * 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
     */

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len + 1];  // dp[i]表示长度为i的最长递增子序列的结尾数字
        int[] record = new int[len];  // record[i]表示第i个位置上参与的最长递增子序列的长度
        int maxLen = 1;
        dp[maxLen] = arr[0];
        record[0] = 1;
        for (int i = 1; i < len; i++) {
            // 如果某个数字大于dp[maxLen]，则新增，maxLen++
            if (arr[i] > dp[maxLen]) {
                dp[++maxLen] = arr[i];
                record[i] = maxLen;
            } else {
                // 将其插入到dp前面替换第一个大于它的数字
                int idx = insert2dp(dp, maxLen, arr[i]);
                record[i] = idx;
            }
        }
        int[] res = new int[maxLen];
        for (int i = record.length - 1; i >= 0; i--) {
            if (record[i] == maxLen)
                res[maxLen-- - 1] = arr[i];
        }
        return res;
    }

    private int insert2dp(int[] dp, int len, int a) {
        int l = 1, r = len;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (dp[mid] <= a) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = l > len ? len : l;
        dp[l] = a;
        return l;
    }

}
