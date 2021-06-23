package LeetCode.链表

/**
 * @Author Aqinn
 * @Date 2021/5/13 10:45 上午
 */
class 回文链表 {

    /**
     * 题目描述:
     * 请判断一个链表是否为回文链表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        // 快满指针找出中间节点
        var slow = head
        var fast = head
        while (fast!!.next != null && fast.next!!.next != null) {
            slow = slow!!.next!!
            fast = fast.next!!.next!!
        }
        // 翻转 slow 后面的链表
        var cur = slow?.next
        var pre: ListNode? = null
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        if (slow != null) {
            slow.next = pre
        }
        // 判断
        var first = head
        var second = slow!!.next
        while (second != null) {
            if (first!!.`val` != second.`val`) {
                return false
            }
            first = first.next
            second = second.next
        }
        return true
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

}