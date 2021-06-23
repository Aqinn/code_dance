package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/22 4:11 下午
 */
public class 两个链表的第一个公共节点 {

    // cost time =>

    /**
     * 题目描述:
     * 输入两个链表，找出它们的第一个公共结点。（
     * 注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
