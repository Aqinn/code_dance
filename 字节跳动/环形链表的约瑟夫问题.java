package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/24 10:48 下午
 */
public class 环形链表的约瑟夫问题 {

    /**
     * 题目描述:
     * 编号为 1 到 n 的 n 个人围成一圈。从编号为 1 的人开始报数 1，依次下去，报到 m 的人离开，
     * 问最后留下的一个人，编号是多少？
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/41c399fdb6004b31a6cbb047c641ed8a
     */

    /**
     * @param n int整型
     * @param m int整型
     * @return int整型
     */



    // 傻瓜式模拟，效率低下
    public int ysf(int n, int m) {
        LinkNode root = new LinkNode(-1);
        LinkNode cur = root;
        for (int i = 1; i <= n; i++) {
            LinkNode temp = new LinkNode(i);
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = root.next;
        int count = m;
        cur = root.next;
        while (cur.next != cur) {
            if (--count == 1) {
                cur.next = cur.next.next;
                count = m;
            }
            cur = cur.next;
        }
        return cur.val;
    }
    class LinkNode {
        int val;
        LinkNode next = null;

        public LinkNode(int val) {
            this.val = val;
        }
    }

}
