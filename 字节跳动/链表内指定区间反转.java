package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/14 4:25 下午
 */
public class 链表内指定区间反转 {

    /**
     * 题目描述:
     * 将一个链表 m 位置到 n 位置之间的区间反转，要求时间复杂度O(N)，空间复杂度O(1)。
     */

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        if (m <= 0 || n <= 0)
            return null;
        if (m == n)
            return head;
        int size = 0;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root;
        ListNode pre = null;
        ListNode tmp;
        ListNode p = null, pNext = null;
        while (size <= n && cur != null) {
            tmp = cur.next;
            if (n == size) {
                cur.next = pre;
                pre = cur;
                p.next = pre;
                pNext.next = tmp;
                break;
            }
            if (m - 1 == size) {
                p = cur;
                pNext = cur.next;
            }
            if (m <= size) {
                cur.next = pre;
                pre = cur;
            }
            cur = tmp;
            size++;
        }
        return root.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
