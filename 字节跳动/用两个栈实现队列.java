package 字节跳动;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/1/30 8:05 下午
 */
public class 用两个栈实现队列 {

    /**
     * 题目描述:
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

}
