package 字节跳动;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/2/26 2:17 下午
 */
public class 加起来和为目标值的组合 {

    /**
     * 题目描述:
     * 给出一组候选数 C 和一个目标数 T，找出候选数中起来和等于 T 的所有组合。
     * C 中的每个数字在一个组合中只能使用一次。
     * 注意：
     * 题目中所有的数字（包括目标数\ T T ）都是正整数
     * 组合中的数字要按非递增排序
     * 结果中不能包含重复的组合
     * 组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/75e6cd5b85ab41c6a7c43359a74e869a
     */

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (num == null || num.length == 0 || target < 0) {
            return res;
        }
        Arrays.sort(num);
        dfs(num, target, res, temp, 0);
        return res;
    }

    private void dfs(int[] num, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if (start >= num.length) {
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            if (num[i] <= target) {
                temp.add(num[i]);
                dfs(num, target - num[i], res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
