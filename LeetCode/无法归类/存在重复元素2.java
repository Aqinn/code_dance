package LeetCode.无法归类;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/4/28 11:55 上午
 */
public class 存在重复元素2 {

    /**
     * 题目描述:
     * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i - k >= 0) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
