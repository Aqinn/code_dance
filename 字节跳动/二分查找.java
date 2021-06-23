package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 4:38 下午
 */
public class 二分查找 {

    /**
     * 题目描述:
     * 请实现有重复数字的升序数组的二分查找。
     * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        二分查找 main = new 二分查找();
        System.out.println(main.upper_bound_(5, 4, new int[]{0, 1, 2, 4, 4, 5}));
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        if (v > a[n - 1]) {
            return n + 1;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (v <= a[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

}
