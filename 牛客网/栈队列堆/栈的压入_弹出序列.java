package 牛客网.栈队列堆;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/1/21 3:14 下午
 */
public class 栈的压入_弹出序列 {

    // cost time => 11:34

    /**
     * 题目描述:
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列 1,2,3,4,5 是某栈的压入顺序，
     * 序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
     * 但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
     */

    public static void main(String[] args) {
        Stack<Integer> data = new Stack<>();
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] check = new int[]{4, 3, 5, 1, 2};
        int idx = 0;
        for (int i = 0; i < in.length; i++) {
            data.push(in[i]);
            while (idx < check.length && check[idx] == data.peek()) {
                data.pop();
                idx++;
            }
        }
        System.out.println(data.empty());
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.pop());
        }
    }

}
