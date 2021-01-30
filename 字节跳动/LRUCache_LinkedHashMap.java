package 字节跳动;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/1/30 12:37 下午
 */
public class LRUCache_LinkedHashMap {

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

    private int mCapacity;
    private Map<Integer, Integer> mMap;

    public LRUCache_LinkedHashMap(int capacity) {
        this.mCapacity = capacity;
        this.mMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!mMap.containsKey(key)) {
            return -1;
        }
        // 先删除旧位置的，再放入新位置
        Integer val = mMap.remove(key);
        mMap.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (mMap.containsKey(key)) {
            mMap.remove(key);
            mMap.put(key, value);
            return;
        }
        mMap.put(key, value);
        // 超出了capacity，就删除最久没有使用那个，也就是遍历器的第一个
        if (mMap.size() > mCapacity) {
            mMap.remove(mMap.keySet().iterator().next());
        }
    }

}
