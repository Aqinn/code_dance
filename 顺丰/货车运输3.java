package 顺丰;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Aqinn
 * @Date 2021/3/10 10:39 下午
 */
public class 货车运输3 {

    // 该题解只通过了 2 个测试用例

    /**
     * 题目名称: 货车运输3
     * <p>
     * 题目描述:
     * 港口新到了n个货物，工人们需要将它们通过货车运送到公司。
     * 货物会先后到达港口，第i个到达港口的货物是第i号，价值是a[i]。
     * 每辆货车可以将编号连续的货物一起运输，花费为该车货物价值的和的平方。
     * 货车有10种型号，均有足够多辆，第i种型号的货车可以容纳至多i个货物，
     * 由于不同型号货车所在位置不同，故每调用新型号的车（之前没有调用过这种型号），就得支付b[i]的成本。
     * 你是运输货车公司的老板，负责将全部货物运送到公司，你想知道最大利润，即花费减去运输成本的最大值是多少。???
     * <p>
     * 输入描述:
     * 第一行一个数n。
     * 接下来n个数a[]，第i个数为a[i]。
     * 接下来10个数b[], 第i个数为b[i]。
     * <p>
     * 输出描述:
     * 一个数表示答案。如果最大利润为负，则输出0。
     * <p>
     * 样例输入:
     * 2
     * 5 5
     * 10 30 100 100 100 100 100 100 100 100
     * <p>
     * 样例输出:
     * 70
     * <p>
     * 提示:
     * 1≤n≤300
     * 0≤a[i]≤100
     * 0≤b[i]≤100,000,000
     * 只选1号车型，答案为40；只选2号车型，答案为70；选1和2号车型，答案为60（调用了两种类型，但是最终只用一辆二号车运载所有货物，100-10-30=60）.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = input.nextInt();
        }
        int[] cars = new int[10];
        for (int i = 0; i < 10; i++) {
            cars[i] = input.nextInt();
        }
        boolean[] carsPay = new boolean[10];
        // 对于编号为 i 的某个货物开始，可以使用 1辆车，也可以使用 2、3、4、5...辆车运送
        // 然后对于新的下标 i+x 的货物也是如此处理
        // 直到发现编号 i 已经等于 vals.length 了，就能输出一次结果了
        getMaxBenefit(vals, cars, carsPay, 0, 0);
        System.out.println(max);
    }

    private static int max = -1;

    private static void getMaxBenefit(int[] vals, int[] cars, boolean[] carsPay, int idx, int benefit) {
        if (idx >= vals.length) {
            max = Math.max(max, benefit);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (vals.length - idx <= i + 1)
                break;
            int nowBenefit = benefit + getAllBenefit(vals, idx, i + 1) - (carsPay[i] ? 0 : cars[i]);
            boolean[] newCarsPay = Arrays.copyOf(carsPay, carsPay.length);
            if (!newCarsPay[i]) {
                newCarsPay[i] = true;
            }
            getMaxBenefit(vals, cars, newCarsPay, idx + i + 1, nowBenefit);
        }
    }

    private static int getAllBenefit(int[] vals, int l, int len) {
        int sum = 0;
        for (int i = l; i < l + len; i++) {
            sum += vals[i];
        }
        return sum * sum;
    }

}
