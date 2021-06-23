package LeetCode.字符串;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/4/13 9:10 上午
 */
public class 反转每对括号间的子串 {

    /**
     * 题目描述:
     * 给出一个字符串s（仅含有小写英文字母和括号）。
     * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     * 注意，您的结果中 不应 包含任何括号。
     * <p>
     * 输入：
     * s = "a(bcdefghijkl(mno)p)q"
     * <p>
     * 输出：
     * "apmnolkjihgfedcbq"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        反转每对括号间的子串 main = new 反转每对括号间的子串();
        System.out.println(main.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(main.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(main.reverseParentheses("ta()usw((((a))))"));
    }

    public String reverseParentheses(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        stack.push("");
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push("");
            } else if (c == ')') {
                // 反转子串，拼接在上一个结果的后面
                String pop = stack.pop();
                StringBuilder pop2 = new StringBuilder(stack.pop());
                for (int k = pop.length() - 1; k >= 0; k--) {
                    char cc = pop.charAt(k);
                    pop2.append(cc);
                }
                stack.push(pop2.toString());
            } else {
                String pop = stack.pop();
                pop += c;
                stack.push(pop);
            }
        }
        return stack.pop();
    }

}
