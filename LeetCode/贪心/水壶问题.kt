package LeetCode.贪心

import java.util.*
import kotlin.collections.HashSet
import kotlin.math.min

/**
 * @Author Aqinn
 * @Date 2021/5/25 11:32 上午
 */
class 水壶问题 {

    /**
     * 题目描述:
     * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
     * 你允许：
     * 1. 装满任意一个水壶
     * 2. 清空任意一个水壶
     * 3. 从一个水壶向另外一个水壶倒水，直到装满或者倒空
     * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     */

    // 深度优先
    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
        val q = LinkedList<IntArray>()
        q.push(intArrayOf(0, 0))
        val seen = HashSet<Long>()
        while (!q.isEmpty()) {
            if (seen.contains(hash(q.peek()))) {
                q.pop()
                continue
            }
            seen.add(hash(q.peek()))
            val pop = q.pop()
            val left = pop[0]
            val right = pop[1]
            if (left == z || right == z || left + right == z) {
                return true
            }
            // 1. 装满 left
            q.push(intArrayOf(x, right))
            // 2. 装满 right
            q.push(intArrayOf(left, y))
            // 3. 倒空 left
            q.push(intArrayOf(0, right))
            // 4. 倒空 right
            q.push(intArrayOf(left, 0))
            // 5. left 往 right 倒
            q.push(intArrayOf(left - min(left, y - right), right + min(left, y - right)))
            // 6. right 往 left 倒
            q.push(intArrayOf(left + min(right, x - left), right - min(right, x - left)))
        }
        return false
    }

    private fun hash(state: IntArray): Long {
        return (state[0] * 10000000001 + state[1]).toLong()
    }

}