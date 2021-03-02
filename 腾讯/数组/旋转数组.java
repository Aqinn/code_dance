package 腾讯.数组;

/**
 * @Author Aqinn
 * @Date 2021/3/2 9:57 上午
 */
public class 旋转数组 {

    /**
     * 题目描述:
     * 一个数组 A 中存有 N（N&gt0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移 M（M>=0）个位置，
     * 即：将 A 中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后 M 个数循环移至最前面的 M 个位置）。
     * 如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
     */

    /**
     * 旋转数组
     *
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve(int n, int m, int[] a) {
        int k = m % n;
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        return a;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
