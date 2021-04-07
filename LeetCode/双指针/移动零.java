package LeetCode.双指针;

/**
 * @Author Aqinn
 * @Date 2021/4/7 9:36 上午
 */
public class 移动零 {

    /**
     * 题目描述:
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */

    public void moveZeroes(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0)
            return;
        int i = 0, j = 0;
        while (j < len) {
            while (j < len && nums[j] == 0)
                j++;
            if (j < len) {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        while (i < len) {
            nums[i] = 0;
            i++;
        }
    }

}
