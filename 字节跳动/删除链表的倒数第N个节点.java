package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 10:44 下午
 */
public class 删除链表的倒数第N个节点 {

    /**
     * 题目描述:
     * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
     */

    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        if (count < n)
            return null;
        if (count == n)
            return res.next;
        head = res;
        while (count-- > n) {
            if (count == n) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;
    }

}
