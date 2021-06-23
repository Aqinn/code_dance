package 字节跳动;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/2/9 10:22 下午
 */
public class 出现次数的TopK问题 {

    /**
     * 题目描述:
     * 给定String类型的数组strArr，再给定整数k，请严格按照排名顺序打印 出次数前k名的字符串。
     * [要求]
     * 如果strArr长度为N，时间复杂度请达到O(NlogK)
     * 输出K行，每行有一个字符串和一个整数（字符串表示）。
     * 你需要按照出现出现次数由大到小输出，若出现次数相同时字符串字典序较小的优先输出
     * <p>
     * 示例输入:
     * ["1","2","3","4"],2
     * 示例输出:
     * [["1","1"],["2","1"]]
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee
     */

    public static void main(String[] args) {
        出现次数的TopK问题 main = new 出现次数的TopK问题();
        String[][] res = main.topKstrings(new String[]{
                "1", "1", "2", "3"
        }, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + ", " + res[i][1]);
        }
    }

    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (counts.containsKey(strings[i])) {
                counts.put(strings[i], counts.get(strings[i]) + 1);
            } else {
                counts.put(strings[i], 1);
            }
        }
        Node[] arr = new Node[counts.size()];
        Iterator<Map.Entry<String, Integer>> iterator = counts.entrySet().iterator();
        int size = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            arr[size++] = new Node(entry.getKey(), entry.getValue());
        }
        // 构建大根堆
        for (int i = (size - 1) / 2; i >= 0; i--) {
            adjust(arr, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            Node temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i);
        }
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = arr[i].key;
            res[i][1] = String.valueOf(arr[i].val);
        }
        return res;
    }

    private void adjust(Node[] arr, int root, int length) {
        Node temp = arr[root];
        int lChild = root * 2 + 1;
        while (lChild < length) {
            if (lChild + 1 < length && !compare(arr[lChild+1], arr[lChild])) {
                lChild++;
            }
            if (!compare(temp, arr[lChild])) {
                break;
            }
            arr[root] = arr[lChild];
            root = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[root] = temp;
    }

    private boolean compare(Node n1, Node n2) {
        if (n1.val != n2.val) {
            return n1.val > n2.val;
        } else {
            return stringCompare(n1.key, n2.key);
        }
    }

    private boolean stringCompare(String s1, String s2) {
        return s1.compareTo(s2) < 0;
    }

    class Node {
        String key;
        int val;

        public Node(String key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", val=" + val +
                    '}';
        }
    }

}
