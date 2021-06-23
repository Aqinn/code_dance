package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/6/23 2:50 下午
 */

/*
题目描述:
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) {
        return null
    }
    var cur1: ListNode? = l1
    var cur2: ListNode? = l2
    var remain = 0
    val res = ListNode(-1)
    var cur = res
    while (cur1 != null && cur2 != null) {
        var add = cur1.`val` + cur2.`val` + remain
        remain = 0
        if (add > 9) {
            remain = add / 10
            add %= 10
        }
        cur.next = ListNode(add)
        cur = cur.next!!
        cur1 = cur1.next
        cur2 = cur2.next
    }
    var longer = cur1 ?: cur2
    while (longer != null) {
        var add = longer.`val` + remain
        remain = 0
        if (add > 9) {
            remain = add / 10
            add %= 10
        }
        cur.next = ListNode(add)
        cur = cur.next!!
        longer = longer.next
    }
    if (remain != 0) {
        cur.next = ListNode(remain)
    }
    return res.next
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}