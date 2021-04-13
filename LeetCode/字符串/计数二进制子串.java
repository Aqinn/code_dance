package LeetCode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/4/11 9:39 下午
 */
public class 计数二进制子串 {

    /**
     * 题目描述:
     * 给定一个字符串s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
     * 重复出现的子串要计算它们出现的次数。
     * <p>
     * 输入:
     * "00110011"
     * <p>
     * 输出:
     * 6
     * <p>
     * 解释:
     * 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     */

    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }


}
