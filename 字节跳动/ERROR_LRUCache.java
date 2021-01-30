package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 9:57 上午
 * 有漏洞的LRUCache，不能支持重复get、put操作
 */
public class ERROR_LRUCache {

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
     **/

//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3, 3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4, 4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
//    }
    public static void main(String[] args) {
        ERROR_LRUCache lruCache = new ERROR_LRUCache(10);
        lruCache.put(10, 13);
        lruCache.put(3, 17);
        lruCache.put(6, 11);
        lruCache.put(10, 5);
        lruCache.put(9, 10);
        System.out.println(lruCache.get(13));
        lruCache.put(2, 19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5, 25);
        System.out.println(lruCache.get(8));
        lruCache.put(9, 22);
        lruCache.put(5, 5);
        lruCache.put(1, 30);
        System.out.println(lruCache.get(11));
        lruCache.put(9, 12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        lruCache.put(4, 30);
        lruCache.put(9, 3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));
    }

    private int mCapacity;
    private int mSize;
    private int mPriority;

    private Entry[] mEntries;

    public ERROR_LRUCache(int capacity) {
        mCapacity = capacity;
        mEntries = new Entry[mCapacity];
        mSize = 0;
        mPriority = 1;
    }

    public int get(int key) {
        if (key <= 0)
            return -1;
        int idx = key % mCapacity;
        Entry target = mEntries[idx];
        while (target != null) {
            if (target.key == key) {
                target.priority = mPriority++;
                return target.value;
            }
            target = target.next;
        }
        return -1;
    }

    // 重复值先覆盖，空位插入，没空位就找空位
    public void put(int key, int value) {
        int idx = key % mCapacity;
        Entry temp = mEntries[idx];
        // 数组当前位置上没有值，则肯定没有重复值，但不能保证此时容量合格，不能直接插入
        if (temp == null && mSize < mCapacity) {
            mEntries[idx] = new Entry(key, value);
            mSize++;
            return;
        }
        // 检查重复值
        if (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                temp.priority = mPriority++;
                return;
            }
            while (temp.next != null) {
                if (temp.next.key == key) {
                    // 插入重复的键值对不算新操作？
//                    if (temp.next.value == value)
//                        return;
                    temp.next.value = value;
                    temp.next.priority = mPriority++;
                    return;
                }
                temp = temp.next;
            }
        }
        // 没有重复值，先判断容量，直接插入在队首
        if (mSize == mCapacity) {
            removeOutEntry();
        }
        temp = mEntries[idx];
        mEntries[idx] = new Entry(key, value);
        mEntries[idx].next = temp;
        mSize++;
    }

    private void removeOutEntry() {
        int outPri = mPriority - mCapacity;
        for (int i = 0; i < mEntries.length; i++) {
            Entry temp = mEntries[i];
            if (temp == null)
                continue;
            if (temp.priority == outPri) {
                mEntries[i] = null;
                mSize--;
                return;
            }
            while (temp.next != null) {
                if (temp.next.priority == outPri) {
                    temp.next = temp.next.next;
                    mSize--;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    private class Entry {
        public int key;
        public int value;
        private Entry next;
        private int priority;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.priority = mPriority++;
        }
    }

}
