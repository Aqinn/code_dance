package LeetCode.无法归类;

/**
 * @Author Aqinn
 * @Date 2021/4/19 11:13 上午
 */
public class 有效的快递序列数目 {

    /**
     * 题目描述:
     * 给你n笔订单，每笔订单都需要快递服务。
     * 请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务delivery(i) 总是在其收件服务pickup(i) 之后。
     * 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
     * <p>
     * 输入：
     * n = 2
     * <p>
     * 输出：
     * 6
     * <p>
     * 解释：
     * 所有可能的序列包括：
     * (P1,P2,D1,D2)，(P1,P2,D2,D1)，(P1,D1,P2,D2)，(P2,P1,D1,D2)，(P2,P1,D2,D1) 和 (P2,D2,P1,D1)。
     * (P1,D2,P2,D1) 是一个无效的序列，因为物品 2 的收件服务（P2）不应在物品 2 的配送服务（D2）之后。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        有效的快递序列数目 main = new 有效的快递序列数目();
        System.out.println(main.countOrders(8));
    }

    public int countOrders(int n) {
        long res = 1;
        int x = 1;
        int mod = 1000000007;
        while (x < n) {
            x++;
            res = res * x % mod * (2L * x - 1) % mod;
        }
        return Integer.parseInt(String.valueOf(res));
    }

}
