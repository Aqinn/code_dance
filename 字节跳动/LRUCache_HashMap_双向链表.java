package 字节跳动;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/1/30 12:46 下午
 */
public class LRUCache_HashMap_双向链表 {

    /**
     * 题目描述:
     * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。
     * 缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
     * <p>
     * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * <p>
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
     * <p>
     * 示例:
     * LRUCache cache = new LRUCache( 2 );  // 缓存容量
     * <p>
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61
     **/

    private int mCapacity;
    private Map<Integer, ListNode> mMap;
    private ListNode mHead;
    private ListNode mTail;

    public LRUCache_HashMap_双向链表(int capacity) {
        this.mCapacity = capacity;
        this.mMap = new HashMap<>();
        mHead = new ListNode(-1, -1);
        mTail = new ListNode(-1, -1);
        mHead.next = mTail;
        mTail.pre = mHead;
    }

    public int get(int key) {
        if (!mMap.containsKey(key)) {
            return -1;
        }
        ListNode target = mMap.get(key);
        // 删除节点
        target.pre.next = target.next;
        target.next.pre = target.pre;
        moveToTail(target);
        return target.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            mMap.get(key).val = value;
            return;
        }
        ListNode newNode = new ListNode(key, value);
        mMap.put(key, newNode);
        moveToTail(newNode);
        if (mMap.size() > mCapacity) {
            mMap.remove(mHead.next.key);
            mHead.next = mHead.next.next;
            mHead.next.pre = mHead;
        }
    }

    private void moveToTail(ListNode node) {
        node.pre = mTail.pre;
        node.next = mTail;
        mTail.pre.next = node;
        mTail.pre = node;
    }

    private class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
