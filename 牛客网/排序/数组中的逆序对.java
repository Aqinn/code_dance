package 牛客网.排序;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/1/24 2:09 下午
 */
public class 数组中的逆序对 {

    /**
     * 题目描述:
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */

    public static void main(String[] args) {
        数组中的逆序对 main = new 数组中的逆序对();
        System.out.println(main.InversePairs(new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575}));
        System.out.println(main.InversePairs(new int[]{1, 2, 5, 3, 4, 0}));
        int[] arr2 = new int[]{1, 8, 9, 2, 5, 3, 4, 7};
        System.out.println(main.InversePairs(arr2));
        System.out.println(Arrays.toString(arr2));
    }

    private static final int MOD = 1000000007;

    public int InversePairs(int[] array) {
        if (array == null) return 0;
        int[] temp = new int[array.length];
        return mergeSort(array, 0, array.length - 1, temp);
    }

    private int mergeSort(int[] array, int low, int high, int[] temp) {
        if (low >= high) return 0;
        int res = 0, mid = (low + high) >> 1;
        res += mergeSort(array, low, mid, temp);
        res %= MOD;
        res += mergeSort(array, mid + 1, high, temp);
        res %= MOD;
        res += merge(array, low, mid, high, temp);
        res %= MOD;
        return res;
    }

    private int merge(int[] array, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, k = low;
        int res = 0;
        while (i <= mid && j <= high) {
            if (array[i] > array[j]) {
                /*
                 * 这里加这么多个的原因是:
                 * 1、左右序列都是升序排序
                 * 2、左边某个数大于右边某个数说明，左边这个数的后续数都是大于该右边的数的
                 * 3、所以用 mid + 1 这个中间数的下标 减去 i
                 */
                res += mid - i + 1;
                res %= MOD;
                temp[k++] = array[j++];
            } else {
                temp[k++] = array[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        for (int l = low; l <= high; l++)
            array[l] = temp[l];
        return res;
    }


//    private static int sum = 0;
//    public int InversePairs(int[] array) {
//        sum = 0
//        getSortArray(array, 0, array.length - 1, new int[array.length]);
//        return sum;
//    }
//
//    public void getSortArray(int[] array, int left, int right, int[] temp) {
//        if (left < right) {
//            int mid = (left + right) >> 1;
//            getSortArray(array, left, mid, temp);
//            getSortArray(array, mid + 1, right, temp);
//            merge(array, left, mid, right, temp);
//        }
//    }
//
//    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
//        // 下面步骤为比较
//        for (int i = left; i <= mid; i++) {
//            for (int j = right; j >= mid + 1; j--) {
//                if (arr[i] > arr[j]) {
//                    sum = (sum + j - mid) % MOD;
//                    break;
//                }
//            }
//        }
//        // 下面步骤为排序
//        // 左序列的指针
//        int i = left;
//        // 右序列的指针
//        int j = mid + 1;
//        int idx = left;
//        // 左右两个序列各拿指针位置的数出来，比较大小，小的先放到 temp 里 + 挪动该序列的指针，大的继续与另一序列的下一个数比对
//        while (i <= mid || j <= right) {
//            // 情况 1: 如果 j > right 却进了循环，那只能说明 i 序列剩下的一股脑丢过去就好了
//            // 情况 2: 如果 i 序列的指针未到底部 且 i序列指针 小于 j序列指针
//            if (j > right || (i <= mid && arr[i] < arr[j])) {
//                temp[idx++] = arr[i++];
//                continue;
//            }
//            // 情况 3: 上述情况若都不满足，那就是要对 j 序列动手了
//            temp[idx++] = arr[j++];
//        }
//        // 拷贝最新数据到原数组中
//        while (--idx >= left) {
//            arr[idx] = temp[idx];
//        }
//    }
}
