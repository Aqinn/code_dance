package 牛客网.栈队列堆;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/1/21 2:47 下午
 */
public class 用两个栈实现队列 {

    // cost time => 6:26

    /**
     * 题目描述:
     * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
     */

    // 栈 : 先进先出
    // 队列: 先进后出

    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();

    public static void main(String[] args) {
        push(3);
        push(4);
        System.out.println(pop());
        push(5);
        push(6);
        System.out.println(pop());
    }

    private static void push(Integer i) {
        in.push(i);
    }

    private static Integer pop() {
        if (in.empty()) {
            return null;
        }
        while (!in.empty()) {
            out.push(in.pop());
        }
        Integer pop = out.pop();
        while (!out.empty()) {
            in.push(out.pop());
        }
        return pop;
    }

}
