package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/22 12:45 下午
 */
public class 反转链表 {

    // cost time => 45:33

    /**
     * 题目描述:
     * 输入一个链表，反转链表后，输出新链表的表头。
     */

    public static void main(String[] args) {
        反转链表 main = new 反转链表();
        反转链表.ListNode root = new 反转链表.ListNode(1);
        root.next = new 反转链表.ListNode(2);
        root.next.next = new 反转链表.ListNode(3);
        root.next.next.next = new 反转链表.ListNode(9);
        root.next.next.next.next = new 反转链表.ListNode(4);
        root.next.next.next.next.next = new 反转链表.ListNode(4);
        root.next.next.next.next.next.next = new 反转链表.ListNode(5);
        ListNode temp = main.ReverseList(root);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = null;
        while (head != null) {
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }

    public ListNode _ReverseList(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode cur;
        ListNode next;
        while (head != null){
            next = head.next;
            cur = head;
            cur.next = root.next;
            root.next = cur;
            head = next;
        }
        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
