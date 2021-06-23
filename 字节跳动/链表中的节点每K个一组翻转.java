package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 8:53 下午
 */
public class 链表中的节点每K个一组翻转 {

    /**
     * 题目描述:
     * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     * 要求空间复杂度 O(1)
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e
     */

    public static void main(String[] args) {
        链表中的节点每K个一组翻转 main = new 链表中的节点每K个一组翻转();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode sout = main.reverseKGroup(root, 6);
        while (sout != null) {
            System.out.print(sout.val + " ");
            sout = sout.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode subTail = head;  // 翻转前的子表表尾
        ListNode subHeadPre = res;  // 翻转前的子表表头的pre
        int count;
        boolean flag = true;
        while (true) {
            count = 0;
            while (head != null) {
                count++;
                subTail = head;
                head = head.next;
                if (count == k) {
                    break;
                }
            }
            if (count != k) {
                break;
            }
            // 翻转
            // head 是剩下子表的表头
            ListNode cur = subHeadPre.next;
            ListNode newSubHeadPre = cur;
            ListNode pre = head;
            while (cur != head) {
                ListNode temp = cur.next;
                if (temp == head && flag) {
                    flag = false;
                    res.next = cur;
                }
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            subHeadPre.next = subTail;
            subHeadPre = newSubHeadPre;
        }
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
