package LeetCode.无法归类

import kotlin.streams.toList

/**
 * @Author Aqinn
 * @Date 2021/5/23 4:02 下午
 */
class 前K个高频元素 {

    /**
     * 题目描述:
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (k <= 0) {
            return IntArray(0)
        }
        val map = mutableMapOf<Int, Int>()
        for (n in nums) {
            map.put(n, map.getOrDefault(n, 0) + 1)
        }
        val res = IntArray(k)
        var idx = 0
        map.entries.sortedBy { -it.value }.subList(0, k).map {
            res[idx++] = it.key
        }
        return res
    }

    // 简短写法
    fun _topKFrequent(nums: IntArray, k: Int): IntArray {
        val map: HashMap<Int, Int> = hashMapOf()
        for (value in nums) map[value] = map.getOrDefault(value, 0) + 1
        return map.entries
            .stream()
            .sorted { o1, o2 -> o2.value - o1.value }
            .map { it.key }
            .toList()
            .subList(0, k)
            .toIntArray()
    }


}

fun main() {
    val main = 前K个高频元素()
    println(main.topKFrequent(intArrayOf(1), 1).contentToString())
}