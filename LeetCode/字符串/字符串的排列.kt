package LeetCode.字符串

/**
 * @Author Aqinn
 * @Date 2021/6/22 1:06 下午
 */

/*
题目描述:
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

限制：
1 <= s 的长度 <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun permutation(s: String): Array<String> {
    val arr = s.toCharArray()
    val res = mutableListOf<String>()
    dfs(arr, 0, res)
    return res.toTypedArray()
}

fun dfs(arr: CharArray, idx: Int, res: MutableList<String>) {
    if (idx == arr.size - 1) {
        res.add(String(arr))
        return
    }
    val set = HashSet<Char>()
    for (i in idx until arr.size) {
        if (!set.contains(arr[i])) {
            set.add(arr[i])
            swap(arr, i, idx)
            dfs(arr, idx + 1, res)
            swap(arr, i, idx)
        }
    }
}

fun swap(arr: CharArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun main() {
    println(permutation("abc").contentToString())
}