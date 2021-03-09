package 字节跳动;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;

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
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
                (o1, o2) -> {
                    return o1.val - o2.val;
                });
        for (ListNode node : lists) {
            if (node != null)
                q.add(node);
        }
        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
            if (cur.next != null)
                q.add(cur.next);
            cur.next = null;
        }
        return res.next;
    }

    public ListNode _mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        Iterator<ListNode> it = lists.iterator();
        while (it.hasNext()) {
            ListNode next = it.next();
            if (next == null)
                it.remove();
        }
        // 上面的 for 循环可以优化为 lists.removeIf(Objects::isNull);
        while (!lists.isEmpty()) {
            ListNode min = findMinAndRemove(lists);
            if (min == null)
                break;
            cur.next = min;
            cur = cur.next;
        }
        return res.next;
    }

    private ListNode findMinAndRemove(ArrayList<ListNode> lists) {
        Iterator<ListNode> it = lists.iterator();
        ListNode min = it.hasNext() ? it.next() : null;
        if (min == null)
            return null;
        while (it.hasNext()) {
            ListNode next = it.next();
            if (min.val > next.val) {
                min = next;
            }
        }
        lists.remove(min);
        if (min.next != null)
            lists.add(min.next);
        return min;
    }

    public ListNode __mergeKLists(ArrayList<ListNode> lists) {
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
