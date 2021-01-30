package 字节跳动;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/1/30 10:43 下午
 */
public class 括号序列 {

    /**
     * 题目描述:
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     */

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0)
                    return false;
                Character cc = stack.pop();
                if (c == ')' && !cc.equals('(')) {
                    return false;
                }
                if (c == ']' && !cc.equals('[')) {
                    return false;
                }
                if (c == '}' && !cc.equals('{')) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

}
