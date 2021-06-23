package 字节跳动;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/2/22 11:51 上午
 */
public class 最大数 {

    /**
     * 题目描述:
     * 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，
     * 返回值需要是 string 类型 否则可能会溢出
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/fc897457408f4bbe9d3f87588f497729
     */

    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        list.sort((s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });
        if (list.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
