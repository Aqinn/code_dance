package 美团.无法分类;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/3/7 7:54 下午
 */
public class 栈和排序 {

    /**
     * 题目描述:
     * 给你一个1->n的排列和一个栈，入栈顺序给定
     * 你要在不打乱入栈顺序的情况下，对数组进行从大到小排序
     * 当无法完全排序时，请输出字典序最大的出栈序列
     * <p>
     * 示例输入:
     * [2,1,5,3,4]
     * <p>
     * 示例输出:
     * [5,4,3,1,2]
     * <p>
     * 说明:
     * 2入栈；1入栈；5入栈；5出栈；3入栈；4入栈；4出栈；3出栈；1出栈；2出栈
     */

    /**
     * 栈排序
     *
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public int[] solve(int[] a) {
        int len;
        if (a == null || (len = a.length) == 0)
            return a;
        Stack<Integer> s = new Stack<>();
        int max = len;
        int[] res = new int[len];
        int idx = 0;
        int i = 0;
        boolean[] isIn = new boolean[len + 1];
        while (i < len) {
            s.push(a[i]);
            // 找出未入栈的最大值，往前顺序数，大于这个值的都可以出栈，直到遇到小于它的
            isIn[a[i]] = true;
            while (max > 0 && isIn[max]) {
                max--;
            }
            // max 是还没入栈的最大值
            while (!s.isEmpty() && s.peek() > max) {
                res[idx++] = s.pop();
            }
            i++;
        }
        return res;
    }

    // ==================== 失败 ======================
    public int[] _solve(int[] a) {
        int len;
        if (a == null || (len = a.length) == 0)
            return a;
        res = new int[len];
        findMaxAndFill(a, 0, len - 1);
        return res;
    }

    private void findMaxAndFill(int[] arr, int start, int end) {
        if (start > end)
            return;
        int maxIdx = start;
        // 找出区间的最大值下标
        for (int i = start; i <= end; i++) {
            if (arr[maxIdx] < arr[i]) {
                maxIdx = i;
            }
        }
        // 将最大值的前面递减的都加入数组
        int i;
        for (i = maxIdx; i > start; i--) {
            if (res[i] >= res[i - 1]) {
                res[idx++] = arr[i];
            } else {
                break;
            }
        }
        res[idx++] = arr[i];
        findMaxAndFill(arr, maxIdx + 1, end);
        findMaxAndFill(arr, start, i - 1);
    }

    private int[] res;
    private int idx = 0;


}
