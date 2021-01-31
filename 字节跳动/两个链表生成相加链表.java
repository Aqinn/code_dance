package 字节跳动;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/1/31 8:28 上午
 */
public class 两个链表生成相加链表 {

    /**
     * 题目描述:
     * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
     */

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        // 两个栈分别存两个链表拆分后的值
        // 出栈相加，拼接新串
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }
        ListNode root = new ListNode(-1);
        int extra = 0;
        int sum = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            sum = extra + s1.pop() + s2.pop();
            extra = 0;
            if (sum > 9) {
                extra = 1;
                sum %= 10;
            }
            ListNode node = new ListNode(sum);
            node.next = root.next;
            root.next = node;
        }
        Stack<Integer> temp = s1.isEmpty() ? s2 : s1;
        while (!temp.isEmpty()) {
            sum = extra + temp.pop();
            extra = 0;
            if (sum > 9) {
                extra = 1;
                sum %= 10;
            }
            ListNode node = new ListNode(sum);
            node.next = root.next;
            root.next = node;
        }
        if (extra > 0) {
            ListNode node = new ListNode(extra);
            node.next = root.next;
            root.next = node;
        }
        return root.next;
    }

    public class ListNode {
        public ListNode(int val) {
            this.val = val;
        }

        int val;
        ListNode next = null;
    }

}
