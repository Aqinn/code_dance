package LeetCode.无法归类;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/2/27 3:23 下午
 */
public class 数组中重复的数据 {

    /**
     * 题目描述:
     * 给定一个整数数组 a，其中 1 ≤ a [i] ≤ n （n 为数组长度）, 其中有些元素出现 两次而其他元素出现一次。
     * <p>
     * 找到所有出现两次的元素。
     * <p>
     * 你可以不用到任何额外空间并在 O (n) 时间复杂度内解决这个问题吗？
     */

    //大佬思路
    // 1. 找到数字 i 时，将位置 i-1 处的数字翻转为负数。
    // 2. 如果位置 i-1 上的数字已经为负，则 i 是出现两次的数字。
    // 其实少了一个排序的过程，但是判题机制竟然不需要排序
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }

    // 稍微有点复杂
    public List<Integer> _findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int i = 0;
        while (i < len) {
            // 就应该在这个位置上
            if (nums[i] == i + 1) {
                ++i;
            }
            // 不应该在这个位置上
            else {
                int temp = Math.abs(nums[i]);
                // 数据范围出错
                if (temp > len)
                    return new ArrayList<>();
                // 重复
                if (temp == Math.abs(nums[temp - 1])) {
                    if (i < temp - 1) {
                        nums[i] = -temp;
                        nums[temp - 1] = temp;
                    } else {
                        nums[i] = temp;
                        nums[temp - 1] = -temp;
                    }
                    i++;
                } else {
                    swap(nums, i, temp - 1);
                }
            }
        }
        for (i = 0; i < len; i++) {
            if (nums[i] < 0)
                res.add(-nums[i]);
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
