package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/31 12:54 下午
 */
public class 合并K个已排序的链表 {

    /**
     * 题目描述:
     * 合并 K 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
     */

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        int size = lists.size();
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        int minIdx = -1;
        while (true) {
            minIdx = -1;
            // 遍历找所有链表的头节点中最小的一个，取出来插入到新链表中
            for (int i = 0; i < size; i++) {
                ListNode head = lists.get(i);
                if (head == null) {
                    continue;
                }
                // 比较头节点值，取得最小头结点
                if (minIdx == -1) {
                    minIdx = i;
                } else {
                    if (head.val < lists.get(minIdx).val) {
                        minIdx = i;
                    }
                }
            }
            // 如果是最后一次遍历了，就可以添加节点了
            if (minIdx != -1) {
                ListNode temp = lists.get(minIdx);
                lists.remove(minIdx);
                lists.add(minIdx, temp.next);
                temp.next = null;
                add(cur, temp);
                cur = cur.next;
            } else {
                break;
            }
        }
        return root.next;
    }

    private void add(ListNode root, ListNode node) {
        ListNode temp = root.next;
        root.next = node;
        node.next = temp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
