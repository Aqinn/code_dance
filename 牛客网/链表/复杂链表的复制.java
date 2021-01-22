package 牛客网.链表;

/**
 * @Author Aqinn
 * @Date 2021/1/22 2:18 下午
 */
public class 复杂链表的复制 {

    // cost time => 1:18:16...Java用太久，引用和实例分不清了

    /**
     * 题目描述:
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
     * 请对此链表进行深拷贝，并返回拷贝后的头结点。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(3);
        root.next.next = new RandomListNode(3);
        root.next.next.next = new RandomListNode(4);

        root.random = root.next.next;
        root.next.next.random = root;

        root = new 复杂链表的复制().Clone(root);
        while (root != null) {
            System.out.print(root.label + " ");
            root = root.next;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        // 复制链表
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 指向随机节点
        cur = pHead;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 拆分
        RandomListNode res = pHead.next;
        cur = pHead;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return res;
    }

    // 我这个拆分的方式也没问题啊，怎么就是过不了呢
    public RandomListNode _Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        // 复制链表
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 指向随机节点
        cur = pHead;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 拆分
        RandomListNode res = new RandomListNode(-1);
        RandomListNode resCur = res;
        cur = pHead;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur = next.next;
            resCur.next = next;
            resCur = resCur.next;
        }
        return res.next;
    }

}
