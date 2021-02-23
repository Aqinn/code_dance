package 字节跳动;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author Aqinn
 * @Date 2021/2/23 10:03 下午
 */
public class 集合的所有子集 {

    /**
     * 题目描述:
     * 现在有一个没有重复元素的整数集合 S，求 S 的所有子集
     * 注意：
     * 你给出的子集中的元素必须按升序排列
     * 给出的解集中不能出现重复的元素
     */

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        LinkedList<Integer> temp = new LinkedList<>();
        solve(S, 0, temp);
        return res;
    }

    private void solve(int[] S, int start, LinkedList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < S.length; i++) {
            temp.add(S[i]);
            solve(S, start + 1, temp);
            temp.removeLast();
        }
    }

}
