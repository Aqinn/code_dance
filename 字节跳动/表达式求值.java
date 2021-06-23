package 字节跳动;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/2/3 1:42 下午
 */
public class 表达式求值 {

    /**
     * 题目描述:
     * 请写一个整数计算器，支持加减乘三种运算和括号。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4
     */

    public static void main(String[] args) {
        表达式求值 main = new 表达式求值();
        System.out.println(main.solve("-1+2*((1*6+4))"));
    }

    public int solve(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int number = 0, sum = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            if (c == '(') {
                int count = 1;
                int j = i + 1;
                while (count > 0) {
                    if (arr[j] == '(') {
                        count++;
                    } else if (arr[j] == ')') {
                        count--;
                    }
                    j++;
                }
                number = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == arr.length - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                number = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
