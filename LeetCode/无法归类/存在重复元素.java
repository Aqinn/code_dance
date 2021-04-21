package LeetCode.无法归类;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/4/21 8:14 上午
 */
public class 存在重复元素 {

    /**
     * 题目描述:
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */

    public boolean containsDuplicate(int[] nums) {
        if (nums == null)
            return false;
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

}
