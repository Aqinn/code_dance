package 牛客网.双指针;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/21 4:54 下午
 */
public class 和为S的连续正数序列 {

    // cost time => 10:13

    /**
     * 题目描述:
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        和为S的连续正数序列 main = new 和为S的连续正数序列();
        for (ArrayList<Integer> list : main.FindContinuousSequence(9)) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start, temp;
        for (start = 1; start < sum; start++) {
            for (int i = 1; i < sum - start; i++) {
                temp = (start + start + i) * (i + 1) / 2;
                if (temp == sum) {
                    ArrayList<Integer> seq = new ArrayList<>();
                    for (int j = start; j <= start + i; j++) {
                        seq.add(j);
                    }
                    res.add(seq);
                }
            }
        }
        return res;
    }

}
