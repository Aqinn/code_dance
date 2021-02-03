package 字节跳动;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/2/3 12:36 下午
 */
public class 设计getMin功能的栈 {

    /**
     * 题目描述:
     * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
     */

    /**
     * return a array which include all ans for op3
     *
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack(int[][] op) {
        // write code here
        s = new Stack<>();
        m = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {
                push(op[i][1]);
            } else if (op[i][0] == 2) {
                pop();
            } else if (op[i][0] == 3) {
                list.add(m.peek());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void push(int v) {
        s.push(v);
        if (m.isEmpty() || v < m.peek()) {
            m.push(v);
        } else {
            m.push(m.peek());
        }
    }

    private int pop() {
        m.pop();
        return s.pop();
    }

    private Stack<Integer> s;
    private Stack<Integer> m;

}
