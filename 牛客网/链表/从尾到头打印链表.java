package 牛客网.链表;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/21 6:13 下午
 */
public class 从尾到头打印链表 {

    // cost time => 14:21

    /**
     * 题目描述:
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        从尾到头打印链表 main = new 从尾到头打印链表();
        ListNode root = new ListNode(1, null);
        root.next = new ListNode(2, null);
        root.next.next = new ListNode(3, null);
        for (Integer i: main.printListFromTailToHead(root)) {
            System.out.print(i + " ");
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 非递归手段
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    // 递归手段
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> _printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public ArrayList<Integer> x_printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pre = listNode;
        while (listNode != null) {
            if (pre.next == null) {
                list.add(pre.val);
                break;
            }
            while (pre.next.next != null) {
                pre = pre.next;
            }
            list.add(pre.next.val);
            pre.next = null;
            pre = listNode;
        }
        return list;
    }

}
