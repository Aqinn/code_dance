package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/21 8:34 下午
 */
public class 链表中倒数第K个结点 {

    // cost time => 6:38

    /**
     * 题目描述:
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9
     */

    public static void main(String[] args) {
        链表中倒数第K个结点 main = new 链表中倒数第K个结点();
        链表中倒数第K个结点.ListNode root = new 链表中倒数第K个结点.ListNode(1);
        root.next = new 链表中倒数第K个结点.ListNode(2);
        root.next.next = new 链表中倒数第K个结点.ListNode(3);
        root.next.next.next = new 链表中倒数第K个结点.ListNode(3);
        root.next.next.next.next = new 链表中倒数第K个结点.ListNode(4);
        root.next.next.next.next.next = new 链表中倒数第K个结点.ListNode(4);
        root.next.next.next.next.next.next = new 链表中倒数第K个结点.ListNode(5);
        show(root);
        System.out.println(main.FindKthToTail(root, 10) == null ? "空" : main.FindKthToTail(root, 10).val);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        if (k > size) {
            return null;
        }
        temp = head;
        while (size != k) {
            temp = temp.next;
            size--;
        }
        return temp;
    }

    private static void show(链表中倒数第K个结点.ListNode listNode) {
        ListNode temp = listNode;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val + " ");
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
