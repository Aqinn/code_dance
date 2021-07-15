package code_dance.LeetCode.动态规划

/*
题目描述:
给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）

示例 1：
输入："banana"
输出："ana"

示例 2：
输入："abcd"
输出：""

提示：
2 <= S.length <= 10^5
S 由小写英文字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-duplicate-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// hash碰撞问题有待解决
fun longestDupSubstring(s: String): String {
    var left = 1
    var right = s.length
    var res = ""
    val mod = 2.pow(63)
    while (left != right) {
        val mid = left + (right - left) / 2
        val temp = rabinKarp(s, mid, mod)
        if (temp != "") {
            res = temp
            left = mid + 1
        } else {
            right = mid
        }
    }
    return res
}

fun rabinKarp(base: String, len: Int, mod: Long): String {
    if (base.length <= len) {
        return ""
    }
    var key = 0L
    for (i in 0 until len) {
        key = (key * 26 + base[i].int) % mod
    }
    val seen = HashSet<Long>()
    seen.add(key)
    var X = 1L
    for (i in 1..len) {
        X = (X * 26) % mod
    }
    for (i in 1 .. base.length - len) {
        key = (key * 26 - base[i - 1].int * X % mod + mod) % mod
        key = (key + base[i + len - 1].int) % mod
        if (seen.contains(key)) {
            return base.substring(i, i + len)
        }
        seen.add(key)
    }
    return ""
}

val Char.int: Int
    get() {
        return this - 'a'
    }

fun Int.pow(n: Int): Long {
    var res = 1L
    for (i in 1..n) {
        res *= this
    }
    return res
}

fun main() {
    println(longestDupSubstring("okmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajvielokmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajviel"))
    // Correct Answer: ma
}