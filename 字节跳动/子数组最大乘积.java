package 字节跳动;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/3/18 2:49 下午
 */
public class 子数组最大乘积 {

    /**
     * 题目描述:
     * 给定一个double类型的数组arr，其中的元素可正可负可0，返回子数组累乘的最大乘积。
     */

    public static void main(String[] args) {
        子数组最大乘积 main = new 子数组最大乘积();
        System.out.println(main.maxProduct(new double[]{0.1, 0.0, 3.0, -2.0, 0.9, -1.3, 5.0, -4.4}));
    }

    public double maxProduct(double[] arr) {
        /**
         动态规划
         类似最大子序和
         不过需要考虑负数的问题：因为一个负数乘以一个负数可能会变为最大
         */
        double min = arr[0];
        double max = min;
        double res = min; //注意：max记录的不是最终的最大值，而是途中每一个选择的最大值，于是需要重新用一个值保存全局最大值。
        for (int i = 1; i < arr.length; i++) {
            double t_max = max;
            //最大值可以从哪些地方产生：
            // 1. arr[i]  2. min*arr[i] 3.max*arr[i]
            max = Math.max(Math.max(arr[i], arr[i] * max), min * arr[i]);
            //最小值可以从哪些地方产生：
            // 1. arr[i]  2.max*arr[i] 3.min*arr[i]
            min = Math.min(Math.min(arr[i], arr[i] * min), t_max * arr[i]);
            res = Math.max(res, max); //更新全局最大值
        }
        return res;
    }

    public double _maxProduct(double[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0)
            return 0;
        double[] dp = new double[len];  // 以数组内下标为 i 的位置结尾的子数组最大乘积
        dp[0] = arr[0];
        double max = dp[0];
        for (int i = 1; i < len; i++) {
            double temp = dp[i - 1] * arr[i];
            if (Math.max(arr[i], temp) == temp) {
                dp[i] = temp;
            } else {
                dp[i] = arr[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
