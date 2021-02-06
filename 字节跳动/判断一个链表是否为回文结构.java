package 字节跳动;

import java.util.Stack;

/**
 * @Author Aqinn
 * @Date 2021/2/6 11:43 下午
 */
public class 判断一个链表是否为回文结构 {

    /**
     * 题目描述:
     * 给定一个链表，请判断该链表是否是回文结构
     */

    public boolean isPail(ListNode head) {
        // write code here
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next = null;
    }

}
