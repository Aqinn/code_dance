package 腾讯.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/3/15 10:43 下午
 */
public class 子集 {

    /**
     * 题目描述:
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c333d551eb6243e0b4d92e37a06fbfc9
     */

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int cur, int[] arr) {
        if (cur == arr.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(arr[cur]);
        dfs(cur + 1, arr);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, arr);
    }

}
