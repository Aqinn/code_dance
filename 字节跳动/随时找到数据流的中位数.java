package 字节跳动;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author Aqinn
 * @Date 2021/2/21 8:21 下午
 */
public class 随时找到数据流的中位数 {

    /**
     * 题目描述:
     * 有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数。请设计一个名叫 MedianHolder 的结构，MedianHolder 可以随时取得之前吐出所有数的中位数。
     * [要求]
     * 1. 如果 MedianHolder 已经保存了吐出的 N 个数，那么将一个新数加入到 MedianHolder 的过程，其时间复杂度是 O (logN)。
     * 2. 取得已经吐出的 N 个数整体的中位数的过程，时间复杂度为 O (1)
     *
     * 每行有一个整数 opt 表示操作类型
     * 若 opt=1，则接下来有一个整数 N 表示将 N 加入到结构中。
     * 若 opt=2，则表示询问当前所有数的中位数
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8c5e99acb1fa4bc3a342cd321100c0cd
     */

    /**
     * the medians
     *
     * @param operations int整型二维数组 ops
     * @return double浮点型一维数组
     */
    public double[] flowmedian(int[][] operations) {
        List<Double> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> {
            return o2 - o1;
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < operations.length; i++) {
            int opt = operations[i][0];
            if (opt == 1) {
                int a = operations[i][1];
                if (maxHeap.isEmpty() || maxHeap.peek() > a) {
                    maxHeap.add(a);
                } else {
                    minHeap.add(a);
                }
                if (maxHeap.size() + 2 == minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                if (maxHeap.size() - 2 == minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
            } else if (opt == 2) {
                if (maxHeap.size() == 0) {
                    list.add(-1D);
                    continue;
                }
                if (maxHeap.size() == minHeap.size()) {
                    list.add((maxHeap.peek() + minHeap.peek()) / 2.0);
                } else {
                    list.add((double) (maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek()));
                }
            }
        }
        double[] res = new double[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
