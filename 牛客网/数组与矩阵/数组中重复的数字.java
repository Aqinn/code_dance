package 牛客网.数组与矩阵;

import java.util.Date;

/**
 * @Author Aqinn
 * @Date 2021/1/18 4:04 下午
 */
public class 数组中重复的数字 {

    /**
     * 题目描述:
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     * <p>
     * 时间复杂度 O(N)，空间复杂度 O(1)
     * <p>
     * Input:
     * {2, 3, 1, 0, 2, 5}
     * <p>
     * Output:
     * 2
     */

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 0, 0, 2, 5};
        System.out.println(findRepeat(target));
    }

    private static int findRepeat(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]])
                    return arr[i];
                swap(arr, i, arr[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
