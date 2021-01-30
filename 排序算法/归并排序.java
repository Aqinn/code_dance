package 排序算法;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/1/24 2:47 下午
 */
public class 归并排序 extends Base {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列的指针
        int i = left;
        // 右序列的指针
        int j = mid + 1;
        int idx = left;
        // 左右两个序列各拿指针位置的数出来，比较大小，小的先放到 temp 里 + 挪动该序列的指针，大的继续与另一序列的下一个数比对
        while (i <= mid || j <= right) {
            // 情况 1: 如果 j > right 却进了循环，那只能说明 i 序列剩下的一股脑丢过去就好了
            // 情况 2: 短路运算至此且循环仍能继续说明i还没越界 则当 i序列指针 小于 j序列指针
            if (j > right || arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
                continue;
            }
            // 情况 3: 上述情况若都不满足，那就是要对 j 序列动手了
            temp[idx++] = arr[j++];
        }
        // 拷贝最新数据到原数组中
        while (--idx >= left) {
            arr[idx] = temp[idx];
        }
    }

}
