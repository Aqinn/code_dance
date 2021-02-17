package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/17 2:30 下午
 */
public class 删除有序链表中重复出现的元素 {

    /**
     * 题目描述:
     * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
     */

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.val == cur.val) {
                    temp = temp.next;
                }
                pre.next = temp;
                cur = temp;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
