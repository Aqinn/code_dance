package 腾讯.二分;

/**
 * @Author Aqinn
 * @Date 2021/3/4 4:50 下午
 */
public class 二分查找 {

    /**
     * 题目描述:
     * 请实现有重复数字的升序数组的二分查找
     * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target,
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
     */

    public int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0)
            return -1;
        int i = 0, j = len - 1, mid = -1;
        while (i < j) {
            mid = (i + j) >> 1;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i] == target ? i : -1;
    }

}
