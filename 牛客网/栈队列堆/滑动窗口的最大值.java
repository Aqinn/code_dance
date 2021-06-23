package 牛客网.栈队列堆;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author Aqinn
 * @Date 2021/1/21 4:15 下午
 */
public class 滑动窗口的最大值 {

    // cost time => 33:53

    /**
     * 题目描述:
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * <p>
     * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，
     * 那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788
     */

    public static void main(String[] args) {
        滑动窗口的最大值 main = new 滑动窗口的最大值();
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        for (Integer i : main.maxInWindows(arr, 3)) {
            System.out.print(i + " ");
        }
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (size > num.length || size < 1) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        list.add(queue.peek());
        for (int i = size; i < num.length; i++) {
            queue.remove(num[i - size]);
            queue.add(num[i]);
            list.add(queue.peek());
        }
        return list;
    }

}
