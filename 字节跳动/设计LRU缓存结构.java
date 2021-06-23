package 字节跳动;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/1/30 2:33 下午
 */
public class 设计LRU缓存结构 {

    /**
     * 题目描述:
     * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * [要求]
     * set和get方法的时间复杂度为O(1)
     * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
     * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     * 对于每个操作2，输出一个答案
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61
     */

    public static void main(String[] args) {
        int[][] ops = new int[][]{
                {1,1,1},
                {1,2,2},
                {1,3,2},
                {2,1},
                {1,4,4},
                {2,2}
        };
        设计LRU缓存结构 main = new 设计LRU缓存结构();
        main.LRU(ops, 3);
    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        int size = 0;
        for(int i=0; i<operators.length; i++){
            if (operators[i][0] == 2) {
                size++;
            }
        }
        int[] res = new int[size];
        cap = k;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        int idx = 0;
        for(int i=0; i<operators.length; i++){
            if(operators[i][0] == 1){
                put(operators[i][1], operators[i][2]);
            }else{
                res[idx++] = get(operators[i][1]);
            }
        }
        return res;
    }

    private Map<Integer, ListNode> map;
    private int cap;
    private ListNode head;
    private ListNode tail;

    private int get(int key){
        // 不包含，-1
        if(!map.containsKey(key)){
            return -1;
        }
        // 包含，取出，放至尾部
        ListNode target = map.get(key);
        target.pre.next = target.next;
        target.next.pre = target.pre;
        moveToTail(target);
        return target.val;
    }

    private void put(int key, int val){
        if(get(key) != -1){
            map.get(key).val = val;
            return;
        }
        ListNode newNode = new ListNode(key, val);
        map.put(key, newNode);
        moveToTail(newNode);
        if (map.size() > cap){
            ListNode del = map.get(head.next.key);
            map.remove(del.key);
            head.next = del.next;
            del.next.pre = head;
        }
    }

    private void moveToTail(ListNode node){
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }

    private class ListNode{
        int key;
        int val;
        ListNode pre;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }



}
