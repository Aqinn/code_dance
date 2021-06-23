package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/2/3 10:09 上午
 */
public class 链表排序 {

    /**
     * 题目描述:
     * 给定一个无序单链表，实现单链表的排序(按升序排序)。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08
     */

    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        // 找到中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newList = slow.next;
        slow.next = null;
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return res.next;
    }


    public ListNode arraylist_sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        list.sort((a, b) -> {
            return a - b;
        });
        cur = head;
        int i = 0;
        while (cur != null) {
            cur.val = list.get(i++);
            cur = cur.next;
        }
        return head;
    }


    public ListNode timeout_sortInList(ListNode head) {
        ListNode begin = head;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        while (size > 0) {
            cur = head;
            int count = size--;
            while (cur != null && count-- > 0) {
                if (cur.next != null && cur.val > cur.next.val) {
                    swap(cur, cur.next);
                }
                cur = cur.next;
            }
        }
        return head;
    }

    private void swap(ListNode pre, ListNode next) {
        int temp = pre.val;
        pre.val = next.val;
        next.val = temp;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
