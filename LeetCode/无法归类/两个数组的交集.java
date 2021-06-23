package LeetCode.无法归类;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/4/22 9:42 上午
 */
public class 两个数组的交集 {

    /**
     * 题目描述:
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        int l1 = nums1.length, l2 = nums2.length;
        for (int i = 0; i < l1; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < l2; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        Iterator<Integer> it = res.iterator();
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        return arr;
    }

}
