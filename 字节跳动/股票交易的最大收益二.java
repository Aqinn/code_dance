package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/11 1:37 下午
 */
public class 股票交易的最大收益二 {

    /**
     * 题目描述:
     * 假定你知道某只股票每一天价格的变动。
     * 你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
     * 请设计一个函数，计算你所能获得的最大收益。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/4892d3ff304a4880b7a89ba01f48daf9
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 4) {
            return 0;
        }
        int[] firstOut = new int[prices.length];
        int[] secIn = new int[prices.length];
        int minPrice = prices[0];
        firstOut[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            firstOut[i] = Math.max(firstOut[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[prices.length - 1];
        secIn[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            secIn[i] = Math.max(secIn[i + 1], maxPrice - prices[i]);
        }
        // System.out.println(Arrays.toString(firstOut));
        // System.out.println(Arrays.toString(secIn));
        int res = 0;
        for (int i = 1; i < prices.length - 2; i++) {
            res = Math.max(res, firstOut[i] + secIn[i + 1]);
        }
        return res;
    }

}
