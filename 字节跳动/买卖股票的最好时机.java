package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 2:52 下午
 */
public class 买卖股票的最好时机 {

    /**
     * 题目描述:
     * 假设你有一个数组，其中第 i 个元素是股票在第 i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec
     */

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxBenefit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            maxBenefit = Math.max(maxBenefit, prices[i] - minPrice);
        }
        return maxBenefit;
    }

}
