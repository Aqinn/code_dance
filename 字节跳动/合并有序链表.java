package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 6:57 下午
 */
public class 合并有序链表 {

    /**
     * 题目描述:
     * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
     */

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode root = l1.val < l2.val ? l1 : l2;
        ListNode other = l1 == root ? l2 : l1;
        ListNode cur = root;
        ListNode temp;
        while (cur.next != null && other != null) {
            if (cur.next.val <= other.val) {
                cur = cur.next;
                continue;
            }
            temp = other;
            other = other.next;
            temp.next = cur.next;
            cur.next = temp;
        }
        if (cur.next == null) {
            cur.next = other;
        }
        return root;
    }

    public ListNode _mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode root = l1.val < l2.val? l1:l2;
        ListNode tail = root;
        l1 = l1==root?l1.next:l1;
        l2 = l2==root?l2.next:l2;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1==null)?l2:l1;
        return root;
    }

    public class ListNode {
        int val;
        ListNode next = null;
    }

}
