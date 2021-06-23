package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 4:25 下午
 */
public class 判断链表中是否有环 {

    /**
     * 题目描述:
     * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
     * 你能给出空间复杂度的解法么？
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9
     */

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
