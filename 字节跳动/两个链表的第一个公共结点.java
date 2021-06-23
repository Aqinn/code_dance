package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/31 11:34 上午
 */
public class 两个链表的第一个公共结点 {

    /**
     * 题目描述:
     * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
     */

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode backup1 = pHead1;
        ListNode backup2 = pHead2;
        while (pHead1 != pHead2) {
            pHead1 = (pHead1 == null) ? backup2 : pHead1.next;
            pHead2 = (pHead2 == null) ? backup1 : pHead2.next;
        }
        return pHead1;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
