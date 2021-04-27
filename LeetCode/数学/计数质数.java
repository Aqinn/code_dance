package LeetCode.数学;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/4/27 9:43 下午
 */
public class 计数质数 {

    /**
     * 题目描述:
     * 统计所有小于非负整数 n 的质数的数量。
     */

    public int countPrimes(int n) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[n];
        int temp;
        Arrays.fill(arr, 1);
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1)
                res.add(i);
            for (int j = 0; j < res.size() && (temp = i * res.get(j)) < n; j++) {
                arr[temp] = 0;
                /*
                 * 现在正在计算的数是某个已知质数的倍数
                 * 代表着继续计算已经并无意义，因为前面已经计算过要继续枚举计算的数了
                 * 所以直接退出
                 */
                if (i % res.get(j) == 0)
                    break;
            }
        }
        return res.size();
    }

}
