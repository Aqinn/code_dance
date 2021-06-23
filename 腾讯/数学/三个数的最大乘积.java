package 腾讯.数学;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/3/3 11:49 上午
 */
public class 三个数的最大乘积 {

    /**
     * 题目描述:
     * 给定一个无序数组，包含正数、负数和 0，要求从中找出 3 个数的乘积，使得乘积最大
     * 要求时间复杂度：O (n)，空间复杂度：O (1)。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8ae05c2913fe438b8b14f3968f64fc0b
     */

    // 只有可能是最大的三个正数的乘积，或者最大的正数与最小的两个负数的乘积
    public long solve(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        long max1, max2, max3, min1, min2;
        Arrays.sort(A);
        max1 = A[len - 1];
        max2 = A[len - 2];
        max3 = A[len - 3];
        min1 = A[0];
        min2 = A[1];
        long res1 = max1 * max2 * max3;
        long res2 = max1 * min1 * min2;
        return Math.max(res1, res2);
    }

}
