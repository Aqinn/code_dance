package 字节跳动;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/3/20 6:32 上午
 */
public class 没有重复项数字的所有排列 {

    /**
     * 题目描述:
     * 给出一组数字，返回该组数字的所有排列
     * 例如：
     * [1,2,3]的所有排列如下
     * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
     * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/4bcf3081067a4d028f95acee3ddcd2b1
     */

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null || num.length < 1) {
            return res;
        }
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<>();
        solve(temp, num);
        return res;
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    private void solve(ArrayList<Integer> list, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        // 遍历 排序过后的数组
        for (int i = 0; i < num.length; i++) {
            // 保证没有重复的元素
            if (!list.contains(num[i])) {
                list.add(num[i]);
                solve(list, num);
                list.remove(list.size() - 1);
            }
        }
    }

}
