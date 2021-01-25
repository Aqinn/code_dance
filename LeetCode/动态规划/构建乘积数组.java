package LeetCode.动态规划;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/1/25 10:28 下午
 */
public class 构建乘积数组 {

    /**
     * 题目描述:
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
     */

    public static void main(String[] args) {
        构建乘积数组 main = new 构建乘积数组();
        System.out.println(Arrays.toString(main.multiply(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] multiply(int[] A) {
        if (A.length <= 1)
            return new int[0];
        int[] B = new int[A.length];
        int[] dp_left = new int[A.length];
        int[] dp_right = new int[A.length];
        dp_left[0] = 1;
        for (int i = 1; i < A.length; i++) {
            dp_left[i] = dp_left[i - 1] * A[i - 1];
        }
        dp_right[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            dp_right[i] = dp_right[i + 1] * A[i + 1];
        }
        for (int i = 0; i < A.length; i++) {
            B[i] = dp_left[i] * dp_right[i];
        }
        return B;
    }

}
