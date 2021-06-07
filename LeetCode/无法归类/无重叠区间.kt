package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/6/7 10:55 上午
 */

/**
 * 题目描述:、给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 * 1、可以认为区间的终点总是大于它的起点。
 * 2、区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */

fun eraseOverlapIntervals(arr: Array<IntArray>): Int {
    if (arr.isEmpty()) {
        return 0
    }

    // 排序，左端点最小值排序
    arr.sortWith(object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o1[1] - o2[1]
        }
    })

    // 持续更新右端点
    val len = arr.size
    var r = arr[0][1]
    var count = 1
    for (idx in 1 until len) {
        if (arr[idx][0] >= r) {
            count++
            r = arr[idx][1]
        }
    }

    // 去掉的个数
    return len - count
}
