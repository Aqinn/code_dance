package LeetCode.数学;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/4/2 9:41 上午
 */
public class 笨阶乘 {

    /**
     * 题目描述:
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * 另外，我们使用的除法是地板除法（floor division），所以10 * 9 / 8等于11。这保证结果是一个整数。
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     * <p>
     * 输入：4
     * 输出：7
     * 解释：7 = 4 * 3 / 2 + 1
     * <p>
     * 输入：10
     * 输出：12
     * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/clumsy-factorial
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        笨阶乘 main = new 笨阶乘();
        System.out.println(main.clumsy(4));
    }

    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        int index = 0; // 用于控制乘、除、加、减
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    // 笨方法
    public int _clumsy(int n) {
        int i = 0;
        LinkedList<Integer> q = new LinkedList<>();
        while (n >= 1) {
            switch (i % 4) {
                case 0:
                    q.offer(n);
                    break;
                case 1:
                    q.offer(q.pollLast() * n);
                    break;
                case 2:
                    q.offer(q.pollLast() / n);
                    break;
                case 3:
                    q.offer(n);
                    break;
                default:
                    return 0;
            }
            i++;
            n--;
        }
        boolean flag = true;
        int sum = q.pollFirst();
        while (!q.isEmpty()) {
            if (flag) {
                sum += q.pollFirst();
            } else {
                sum -= q.pollFirst();
            }
            flag = !flag;
        }
        return sum;
    }

}
