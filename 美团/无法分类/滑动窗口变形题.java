package 美团.无法分类;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/3/13 11:26 下午
 */
public class 滑动窗口变形题 {

    /**
     * 2021 春招 美团笔试第三题
     * 只通过了73%数据，在时间或空间复杂度上出了问题
     * 题目描述:
     * 小美正在统计她公司的数据。她想要知道一定时间段内的某种特征，因此，她将n条数据按时间排好序依次给出，想要知道以某条数据开始的一个连续数据段内数据的众数情况。
     * 形式化地，给出n个数a1,.....,an分别表示时刻1,2,....,n的数据值。
     * 小美想要知道连续K条数据的情况，即ai,...,ai+K-1。请你求出当i=1,2,...,n-K+1时，ai,...,ai+K-1这些数据中的"众数"。
     * 如果"众数"有多个，输出最小的那一个。
     * 注意，此处“众数”的定义与通常定义有些许区别。
     * 我们这样定义 “众数”：如果出现次数最多的数只有一个数，那么“众数”就是它；否则，众数为出现次数最多的数中，数值最小的那一个。
     * 例如，序列[1 2 3 3]中， 3出现了两次，其他数仅出现了一次，所以“众数”为3。
     * 序列[1 2 3]中，三个数出现次数都为1次，都是出现次数最多的数（不存在出现次数大于1的数），所以“众数”是其中的数值最小的1。
     * 序列[5 2 5 2 3 3 4]中，5、2、3均出现了2次，都是出现次数最多的数（不存在出现次数大于2的数），所以“众数”是其中的数值最小的2。
     * <p>
     * 输入描述:
     * 第一行两个数n和K分别表示数据总量以及她想要了解的连续数据长度。
     * 第二行n个数a1,...,an，表示各个数据值。
     * 1≤K≤n≤105， 1≤ai≤109
     * <p>
     * 输出描述:
     * 输出n-K+1行，每行一个数，依次表示从i=1到i=n-K+1时，ai,...,ai+K-1中的众数。如果众数有多个，输出最小的那一个。
     * <p>
     * 样例输入:
     * 5 3
     * 1 2 2 1 3
     * <p>
     * 样例输出:
     * 2
     * 2
     * 1
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(arr[i]);
            if (linkedList.size() >= k) {
                res.add(findZS(linkedList));  // 方法一
                // res.add(findZhongShu(linkedList));  // 方法二
                linkedList.removeFirst();
            }
        }
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    private static Integer findZS(LinkedList<Integer> linkedList) {
        int[] arr = new int[linkedList.size()];
        int j = 0;
        int minNumber = Integer.MAX_VALUE;
        for (Integer integer : linkedList) {
            arr[j++] = integer;
            minNumber = Math.min(minNumber, integer);
        }
        heapSort(arr);
        int len = arr.length;
        int maxCount = 1;
        int curCount = 1;
        int preNum = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] == preNum) {
                curCount++;
            } else {
                curCount = 1;
                preNum = arr[i];
            }
            maxCount = Math.max(curCount, maxCount);
        }
//        System.out.println("maxCount: " + maxCount);
        if (maxCount == 1) {
            return arr[0];
        } else {
            int count = 1;
            int nowPreNum = arr[0];
            for (int i = 1; i < len; i++) {
                if (arr[i] == nowPreNum) {
                    count++;
                } else {
                    count = 1;
                    nowPreNum = arr[i];
                }
                if (count == maxCount)
                    return arr[i];
            }
        }
        return arr[0];
    }

    private static void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjust(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i);
        }
    }

    private static void adjust(int[] arr, int root, int len) {
        int temp = arr[root];
        int lChild = root * 2 + 1;
        while (lChild < len) {
            if (lChild + 1 < len && arr[lChild] < arr[lChild + 1])
                lChild++;
            if (temp >= arr[lChild]) break;
            arr[root] = arr[lChild];
            root = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[root] = temp;
    }

    private static Integer findZhongShu(LinkedList<Integer> linkedList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int minNumber = Integer.MAX_VALUE;
        for (Integer i : linkedList) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > maxCount) {
                maxCount = map.get(i);
            }
            minNumber = Math.min(minNumber, i);
        }
        if (maxCount == 1) {
            return minNumber;
        } else {
            int minZS = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == maxCount) {
                    minZS = Math.min(minZS, e.getKey());
                }
            }
            return minZS;
        }
    }

}
