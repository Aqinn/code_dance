package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/3/19 8:23 下午
 */
public class 寻找峰值 {

    /**
     * 题目描述:
     * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
     * 假设 nums[-1] = nums[n] = -∞。
     */

    // 思路:
    // 从数组最右边开始找，如果发现右边元素大于等于左边的，那就是山峰，否则继续上一个下标上数的比较
    public int solve(int[] a) {
        int max = a[0];
        int len = a.length;
        int i = len - 1;
        while (i >= 0) {
            if (i - 1 >= 0 && a[i] >= a[i - 1]) {
                return i;
            } else {
                i--;
            }
        }
        return 0;
    }

}
