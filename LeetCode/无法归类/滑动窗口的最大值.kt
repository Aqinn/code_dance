package LeetCode.无法归类

import java.util.*
import kotlin.Comparator

/**
 * @Author Aqinn
 * @Date 2021/5/12 10:09 上午
 */
class 滑动窗口的最大值 {

    /**
     * 题目描述:
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */

    /**
     * 简单利用优先队列，超时解法
     */
    fun _maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || nums.size < k)
            return IntArray(0)
        val q = PriorityQueue<Int> { i1, i2 -> i2 - i1 }
        val res = IntArray(nums.size - k + 1)
        var resSize = 0
        for (i in nums) {
            q.offer(i)
            if (q.size == k) {
                res[resSize++] = q.peek()
                q.remove(nums[resSize - 1])
            }
        }
        return res
    }

    /**
     * 维护了一个单调双向链表
     */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || nums.size < k) {
            return IntArray(0)
        }
        val res = IntArray(nums.size - k + 1)
        val q = LinkedList<Int>()
        for ((idx, value) in nums.withIndex()) {
            if (idx < k - 1) {
                q.offerMonotonic(value)
            } else {
                q.offerMonotonic(value)
                res[idx - k + 1] = q.max()
                q.poll(nums[idx - k + 1])
            }
        }
        return res
    }

    private fun <T : Comparable<T>> Deque<T>.offerMonotonic(t: T) {
        while (isNotEmpty() && peekLast() < t) {
            pollLast()
        }
        offer(t)
    }

    private fun <T> Deque<T>.max(): T {
        return peekFirst()!!
    }

    private fun <T> Deque<T>.poll(t: T) {
        if (isNotEmpty() && peekFirst() == t) {
            pollFirst()
        }
    }

}

fun main() {
    var q = PriorityQueue<Int>(object : Comparator<Int> {
        override fun compare(i1: Int, i2: Int): Int {
            return i2 - i1
        }
    })  // 仅仅是为了尝试一下复杂的写法
    val arr = 滑动窗口的最大值().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
    arr.forEach(System.out::println)
}