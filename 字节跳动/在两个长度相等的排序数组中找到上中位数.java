package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/15 11:19 下午
 */
public class 在两个长度相等的排序数组中找到上中位数 {

    /**
     * 题目描述:
     * 给定两个有序数组 arr1 和 arr2，已知两个数组的长度都为 N，求两个数组中所有数的上中位数。
     * 上中位数：假设递增序列长度为 n，若 n 为奇数，则上中位数为第 n/2+1 个数；否则为第 n/2 个数。
     * <p>
     * [要求]
     * 时间复杂度为O(logN)，额外空间复杂度为O(1)
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/6fbe70f3a51d44fa9395cfc49694404f
     *
     * 参考题解:
     * https://www.cnblogs.com/kubidemanong/p/10562292.html
     */

    // 递归版本
    public static int getUpMedian(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return -1;
        }
        // 开始寻找
        return find(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
    }
    public static int find(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2) {
        int mid1 = l1 + (r1 - l1) / 2;
        int mid2 = l2 + (r2 - l2) / 2;
        // 表示数组只剩下一个数，把两个数组中较小的数返回去
        if (l1 >= r1) {
            return Math.min(arr1[l1], arr2[l2]);
        }
        // 元素个数为奇数，则offset为0，为偶数则 offset 为 1
        int offset = ((r1 - l1 + 1) & 1) ^ 1;// 用位运算比较快
        if (arr1[mid1] < arr2[mid2]) {
            return find(arr1, mid1 + offset, r1, arr2, l2, mid2);
        } else if (arr1[mid1] > arr2[mid2]) {
            return find(arr1, l1, mid1, arr2, mid2 + offset, r2);
        } else {
            return arr1[mid1];// 返回 arr2[mid2]也可以。
        }
    }

    // 迭代版本
    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return -1;
        }
        int l1 = 0, r1 = arr1.length - 1;
        int l2 = 0, r2 = arr2.length - 1;
        int mid1 = 0, mid2 = 0;
        int offset = 0;
        while (l1 < r1) {
            mid1 = (l1 + r1) >> 1;
            mid2 = (l2 + r2) >> 1;
            offset = ((r1 - l1 + 1) & 1) ^ 1;
            if (arr1[mid1] < arr2[mid2]) {
                l1 = mid1 + offset;
                r2 = mid2;
            } else if (arr1[mid1] > arr2[mid2]) {
                r1 = mid1;
                l2 = mid2 + offset;
            } else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[l1], arr2[l2]);
    }

    // 未理解方法
    public int _findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int m = arr1.length;
        return _findMedianinTwoSortedAray(arr1, 0, m - 1, arr2, 0, m - 1, m);
    }
    public int _findMedianinTwoSortedAray(int[] a1, int l1, int r1, int[] a2, int l2, int r2, int k) {
        int m = r1 - l1 + 1;
        int n = r2 - l2 + 1;
        if (m == 0) {
            return a2[l2 + k - 1];
        }
        if (k == 1) {
            return Math.min(a1[l1], a2[l2]);
        }
        int i1 = l1 + Math.min(m, k / 2) - 1;
        int i2 = l2 + Math.min(n, k / 2) - 1;
        if (a1[i1] > a2[i2]) {
            return _findMedianinTwoSortedAray(a1, l1, r1, a2, i2 + 1, r2, k - (i2 - l2) - 1);
        } else {
            return _findMedianinTwoSortedAray(a1, l1 + 1, r1, a2, l2, r2, k - (i1 - l1) - 1);
        }
    }

}
