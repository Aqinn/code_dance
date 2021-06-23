package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 10:20 下午
 */
public class 链表中环的入口节点 {

    /**
     * 题目描述:
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * 拓展：
     * 你能给出不利用额外空间的解法么？
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4
     */


    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
