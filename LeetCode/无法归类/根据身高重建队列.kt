package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/6/12 10:44 上午
 */

/**
 * 题目描述:
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
解释：
编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    if (people.size <= 1) {
        return people
    }

    // 排序，第一关键字身高升序，第二关键字人数降序
    people.sortWith(object : Comparator<IntArray> {
        override fun compare(arr1: IntArray, arr2: IntArray): Int {
            return if (arr1[0] == arr2[0]) {
                arr2[1] - arr1[1]
            } else {
                arr1[0] - arr2[0]
            }
        }
    })

    val res = Array(people.size) {
        IntArray(2).apply {
            fill(-1)
        }
    }
    for (arr in people) {
        var count = arr[1]
        for (i in res.indices) {
            if (res[i][0] == -1) {
                if (count == 0) {
                    res[i] = arr
                    break
                }
                count--
            }
        }
    }

    return res
}
