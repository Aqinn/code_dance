package LeetCode.动态规划;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/1/24 11:04 下午
 */
public class N个骰子的点数 {

    /**
     * 题目描述:
     * 把 n 个骰子扔在地上，求点数和为 s 的概率。
     */

    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     * <p>
     * 解法:
     * 从 n=2 开始（因为 n=1 可以直接写出来），根据 n-1 的情况记录 n 个骰子时和为 sum 的概率
     */
    public List<Map.Entry<Integer, Double>> _dicesSum(int n) {
        Map<Integer, Double> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Double> temp = new HashMap<>();
            for (int j = 1; j <= 6; j++) {
                // 当 n=1 时
                if (res.size() == 0) {
                    temp.put(j, 1D / 6);
                    continue;
                }
                // 当 n>1 时，模拟 n-1 时所有骰子结果的情况，再加上本次投出的骰子概率值
                for (Map.Entry<Integer, Double> entry : res.entrySet()) {
                    // 获得 n-1 情况下的 “和”or“结果”
                    Integer lastSum = entry.getKey();
                    // n-1 的和   +   最新一颗骰子点数   =   现在的和
                    Integer nowSum = lastSum + j;
                    // 现在的和的已有概率（可能别的模拟情况中已经模拟到该和，所以要加上已有概率，默认为0.0代表还没模拟过这个和）
                    Double nowHaveBeenProbability = temp.getOrDefault(nowSum, 0.0);
                    // 在本次情况下要想出现 “该 n-1 情况下的和” 的概率。为什么要除6呢？本题关键点
                    // 因为 “该 n-1 情况下的和” 出现的概率为 entry.getValue()，
                    // 但是 “该 n-1 情况下的和” 为 “本次的和情况" 所用的概率需要除6，
                    // 因为假设 “本次的和情况" 为 nowSum = lastSum + 1，
                    // 那仍然会有 lastSum + 2/3/4/5/6 这5种情况的存在，
                    // 所以需要除6
                    Double lastProbabilityAtNow = entry.getValue() / 6;
                    temp.put(nowSum, nowHaveBeenProbability + lastProbabilityAtNow);
                }
            }
            res = temp;
        }
        return new ArrayList<>(res.entrySet());
    }

    // 使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= face && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));

        return ret;
    }

//    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
//
//        // 背包类型 dp[i][j] 代表概率 i次掷骰子和为j
//        double[][] dp = new double[n + 1][6 * n + 1];
//        for (int i = 1; i <= 6; i++) dp[1][i] = 1.0d / 6;
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = i; j <= i * 6; j++) {
//                for (int k = 1; k <= 6; k++) {
//                    if (j > k) {
//                        dp[i][j] += dp[i - 1][j - k];
//                    }
//                }
//                dp[i][j] /= 6.0d;
//            }
//        }
//        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
//
//        for (int i = n; i <= n * 6; i++) {
//            result.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]));
//        }
//
//        return result;
//    }

}
