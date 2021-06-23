package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/21 6:47 下午
 */
public class 删除链表中重复的节点 {

    // cost time => 56:31

    /**
     * 题目描述:
     * 删除链表中重复的节点
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024
     */

    public static class ListNode {
        int val;
        删除链表中重复的节点.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, 删除链表中重复的节点.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        删除链表中重复的节点 main = new 删除链表中重复的节点();
        删除链表中重复的节点.ListNode root = new 删除链表中重复的节点.ListNode(1, null);
        ListNode temp = root;
        root.next = new 删除链表中重复的节点.ListNode(2, null);
        root.next.next = new 删除链表中重复的节点.ListNode(3, null);
        root.next.next.next = new 删除链表中重复的节点.ListNode(3, null);
        root.next.next.next.next = new 删除链表中重复的节点.ListNode(4, null);
        root.next.next.next.next.next = new 删除链表中重复的节点.ListNode(4, null);
        root.next.next.next.next.next.next = new 删除链表中重复的节点.ListNode(5, null);
        while (temp.next != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val + " ");
        System.out.println();
        main.deleteDuplication(root);
        while (root.next != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.print(root.val + " ");
    }

    // 递归
    public ListNode _deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    // 遍历
    public ListNode __deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        ListNode root = new ListNode(-1);
        root.next = pHead;
        ListNode pre = root;
        ListNode cur = pre.next;
        while(cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return root.next;
    }

}
