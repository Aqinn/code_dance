package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/6 1:03 下午
 */
class 从英文中重建数字 {

    /**
     * 题目描述:
     * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
     *
     * 注意:
     * 输入只包含小写英文字母。
     * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
     * 输入字符串的长度小于 50,000。
     */

    fun originalDigits(s: String): String {
        val map = IntArray(26)
        for (ch in s) {
            map[ch - 'a']++
        }
        val arr = IntArray(10)
        arr[0] = map['z' - 'a']
        arr[2] = map['w' - 'a']
        arr[4] = map['u' - 'a']
        arr[6] = map['x' - 'a']
        arr[8] = map['g' - 'a']
        arr[7] = map['s' - 'a'] - arr[6]
        arr[3] = map['h' - 'a'] - arr[8]
        arr[1] = map['o' - 'a'] - arr[0] - arr[2] - arr[4]
        arr[5] = map['f' - 'a'] - arr[4]
        arr[9] = map['i' - 'a'] - arr[5] - arr[6] - arr[8]
        val res = StringBuilder()
        for (idx in arr.indices) {
            for (i in 1..arr[idx]) {
                res.append(idx)
            }
        }
        return res.toString()
    }

}