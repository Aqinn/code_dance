package LeetCode.无法归类;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/4/4 10:13 下午
 */
public class FizzBuzz {

    /**
     * 题目描述:
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * 1. 如果n是3的倍数，输出“Fizz”；
     * 2. 如果n是5的倍数，输出“Buzz”；
     * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fizz-buzz
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

}
