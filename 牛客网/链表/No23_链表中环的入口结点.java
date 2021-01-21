package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/21 8:46 下午
 */
public class No23_链表中环的入口结点 {

    // cost time > 60mins
    // 题目需要画图助解

    /**
     * 题目描述:
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。要求不能使用额外的空间。
     */

    public static void main(String[] args) {
        No23_链表中环的入口结点 main = new No23_链表中环的入口结点();
        No23_链表中环的入口结点.ListNode root = new No23_链表中环的入口结点.ListNode(1);
        root.next = new No23_链表中环的入口结点.ListNode(2);
        root.next.next = new No23_链表中环的入口结点.ListNode(3);
        root.next.next.next = new No23_链表中环的入口结点.ListNode(9);
        root.next.next.next.next = new No23_链表中环的入口结点.ListNode(4);
        root.next.next.next.next.next = new No23_链表中环的入口结点.ListNode(4);
        root.next.next.next.next.next.next = new No23_链表中环的入口结点.ListNode(5);
        root.next.next.next.next.next.next.next = root.next.next.next;
        System.out.println(main.EntryNodeOfLoop(root) == null ? "无环" : main.EntryNodeOfLoop(root).val);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        // 检测有没有环
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                return null;
            fast = fast.next;
            if (slow == fast && slow != null) {
                break;
            }
        }
        // 有环，相遇在 fast
        slow = pHead;
        while (slow != null) {
            if (slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
