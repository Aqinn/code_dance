package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/21 6:34 下午
 */
public class 在O1时间内删除链表节点 {

    // cost time => 10:25

    /**
     * 题目描述:
     * 在O(1)时间内删除链表节点
     *
     * 来源：牛客
     * 链接：
     */

    public static class ListNode {
        int val;
        在O1时间内删除链表节点.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, 在O1时间内删除链表节点.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (tobeDelete.next == null){
            if (head == tobeDelete) {
                head = null;
            } else {
                ListNode pre = head;
                while (pre.next != tobeDelete) {
                    pre = pre.next;
                }
                pre.next = null;
            }
        } else {
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        }
        return head;
    }

}
