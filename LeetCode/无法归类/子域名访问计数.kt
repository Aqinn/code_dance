package LeetCode.无法归类

/**
 * @Author Aqinn
 * @Date 2021/5/6 10:42 上午
 */
class 子域名访问计数 {

    /**
     * 题目描述:
     * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。
     * 作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。
     * 当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名"com"。
     * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。
     * 其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
     * 接下来会给出一组访问次数和域名组合的列表cpdomains。
     * 要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
     */

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val temp = mutableMapOf<String, Int>()
        for (str in cpdomains) {
            val split = str.split(" ")
            val count = split[0].toInt()
            addDomainsToList(split[1], temp, count)
        }
        val res = mutableListOf<String>()
        temp.map {
            res.add(it.value.toString() + " " + it.key)
        }
        return res
    }

    fun addDomainsToList(domain: String, temp: MutableMap<String, Int>, count : Int) {
        var d = domain
        while (d.isNotEmpty()) {
            temp.put(d, temp.getOrDefault(d, 0) + count)
            d = d.substringAfter('.', "")
        }
    }

}