package LeetCode.贪心;

/**
 * @Author Aqinn
 * @Date 2021/1/23 8:01 下午
 */
public class 股票的最大利润 {

    // cost time => 11:01

    /**
     * 题目描述:
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * <p>
     * 输入: [7,1,5,3,6,4]
     * <p>
     * 输出: 5
     * <p>
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出时间需要大于买入时间。
     */

    public static void main(String[] args) {
        System.out.println(new 股票的最大利润().maxProfit(new int[]{2,1,2,1,0,1,2}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public int _maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] profit = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit[i] = Math.max(profit[i], prices[j] - prices[i]);
            }
        }
        for (int i = 0; i < profit.length - 1; i++) {
            for (int j = 0; j < profit.length - i - 1; j++) {
                if (profit[j] < profit[j + 1]) {
                    int temp = profit[j];
                    profit[j] = profit[j + 1];
                    profit[j + 1] = temp;
                }
            }
        }
        return profit[0];
    }

}
