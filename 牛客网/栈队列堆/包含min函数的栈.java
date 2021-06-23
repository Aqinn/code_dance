package 牛客网.栈队列堆;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/1/21 2:58 下午
 */
public class 包含min函数的栈 {

    /**
     * 题目描述:
     * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c623426af02d4c189f92f2a99647bd34
     */

    private static Stack<Integer> data = new Stack<>();
    private static Stack<Integer> minData = new Stack<>();

    public static void main(String[] args) {
        push(3);
        System.out.println(min());
        push(1);
        System.out.println(min());
        pop();
        push(5);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(3);
        push(3);
        System.out.println(min());
        pop();
        System.out.println(min());
    }

    private static void push(Integer i) {
        data.push(i);
        minData.push(minData.empty() ? i : Math.min(i, minData.peek()));
    }

    private static Integer min() {
        return minData.peek();
    }

    private static void pop() {
        data.pop();
        minData.pop();
    }

}
