package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/3/17 10:24 下午
 */
public class 股票无限次交易 {

    /**
     * 题目描述:
     * 假定你知道某只股票每一天价格的变动。
     * 你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
     * 请设计一个函数，计算你所能获得的最大收益。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/9e5e3c2603064829b0a0bbfca10594e9
     */

    /**
     * 题解:
     * 仔细想想，其实如果后一天比前一天的价格高的话，这个价格差就是我们能赚到的
     * 全部这样的价格差加起来就是最终的最大收益
     * （可以脑补一下各种特例情况，其实都离不开这样的描述）
     */

    public int maxProfit(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < len; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                sum += temp;
            }
        }
        return sum;
    }

}
