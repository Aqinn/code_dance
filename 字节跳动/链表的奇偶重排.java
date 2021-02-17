package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/2/17 3:11 下午
 */
public class 链表的奇偶重排 {

    /**
     * 题目描述:
     * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
     * 注意是节点的编号而非节点的数值。
     */

    // 思路清晰
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode jiCur = head;
        ListNode ouHead = head.next;
        ListNode ouCur = head.next;
        while (ouCur != null && ouCur.next != null) {
            jiCur.next = ouCur.next;
            jiCur = jiCur.next;
            ouCur.next = ouCur.next.next;
            ouCur = ouCur.next;
        }
        jiCur.next = ouHead;
        return head;
    }

    // 稍微聪明一点点的做法，但逻辑还不够清晰
    public ListNode _oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode jiCur = head;
        ListNode ouHead = head.next;
        ListNode ouCur = head.next;
        while (jiCur != null && ouCur != null) {
            if (ouCur.next != null) {
                jiCur.next = ouCur.next;
                jiCur = jiCur.next;
                if (jiCur.next != null) {
                    ouCur.next = jiCur.next;
                    ouCur = ouCur.next;
                } else {
                    ouCur.next = null;
                    jiCur.next = ouHead;
                    break;
                }
            } else {
                ouCur.next = null;
                jiCur.next = ouHead;
                break;
            }
        }
        return head;
    }

    // 暴力做法
    public ListNode __oddEvenList(ListNode head) {
        ArrayList<Integer> ji = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        ListNode cur = head;
        boolean flag = true;
        while (cur != null) {
            if (flag)
                ji.add(cur.val);
            else
                ou.add(cur.val);
            flag = !flag;
            cur = cur.next;
        }
        cur = head;
        int jiIdx = 0, ouIdx = 0;
        while (cur != null) {
            if (jiIdx < ji.size())
                cur.val = ji.get(jiIdx++);
            else
                cur.val = ou.get(ouIdx++);
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;
    }

}
