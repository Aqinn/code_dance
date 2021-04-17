package 面试算法题;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/4/17 9:17 下午
 */
public class 字符串中的字符顺序 {

    /**
     * 题目描述:
     * 小明得到一个只包含ab两个字符的字符串,但是小明不希望在这个字符串里a出现在b左边。
     * 现在他可以将"ab"这样的子串替换成”bba",在原串中的相对位置不变。输出小明最少需要操作多少次才能让一个给定字符串所有a都在b的右边。
     * <p>
     * 输入描述:
     * 一个只包含a,b字符的字符串,长度不超过10000
     * <p>
     * 输出描述:
     * 最小的操作次数。结果对100000007取模。
     */


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(solve(str));
    }

    public static int solve(String str) {
        if (str == null)
            return 0;
        int count = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder(str);
        int last = sb.length() - 1;
        while (last >= 0) {
            if (sb.charAt(last) == 'b') {
                flag = true;
                last--;
                continue;
            }
            if (flag && sb.charAt(last) == 'a') {
                flag = false;
                sb.deleteCharAt(last + 1);
                sb.insert(last, 'b');
                sb.insert(last, 'b');
                last = sb.length() - 1;
                count++;
                count %= 100000007;
                continue;
            }
            last--;
        }
        return count;
    }


}
