package LeetCode.链表;

/**
 * @Author Aqinn
 * @Date 2021/4/26 10:33 下午
 */
public class 移除链表元素 {

    /**
     * 题目描述:
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * <p>
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     */

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode cur = root;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
