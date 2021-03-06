package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 6:25 下午
 */
public class 子数组的最大累加和 {

    /**
     * 题目描述:
     * 给定一个数组arr，返回子数组的最大累加和
     * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
     * 题目保证没有全为负数的数据
     * [要求]
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(1)
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/554aa508dd5d4fefbf0f86e5fe953abd
     */

    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        int now = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            now = Math.max(now + arr[i], arr[i]);
            if (now > max) {
                max = now;
            }
        }
        return max;
    }

}
