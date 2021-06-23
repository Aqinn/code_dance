package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/22 11:11 上午
 */
public class 删除有序链表中重复元素 {

    /**
     * 题目描述：
     * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79
     */

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                    continue;
                }
            } else {
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;
    }

}
