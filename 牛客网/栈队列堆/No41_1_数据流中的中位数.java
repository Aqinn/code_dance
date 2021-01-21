package 牛客网.栈队列堆;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/21 3:53 下午
 */
public class No41_1_数据流中的中位数 {

    // cost time => 11:41

    /**
     * 题目描述:
     * 如何得到一个数据流中的中位数？
     * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     */

    public static void main(String[] args) {
        No41_1_数据流中的中位数 main = new No41_1_数据流中的中位数();
        main.Insert(3);
        System.out.println(main.GetMedian());
        main.Insert(6);
        System.out.println(main.GetMedian());
        main.Insert(9);
        System.out.println(main.GetMedian());
        main.Insert(3);
        for (Integer i: main.list
             ) {
            System.out.print(i + " ");
        }
        System.out.println(main.GetMedian());
    }

    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        int size = list.size();
        int i=0;
        for(; i<size; i++){
            if (num<list.get(i))
                break;
        }
        list.add(i, num);
    }

    public Double GetMedian() {
        int size = list.size();
        if (size % 2 == 0)
            return (list.get(size/2-1) + list.get(size/2))/2.0;
        else
            return list.get(size/2) * 1.0;
    }

}
