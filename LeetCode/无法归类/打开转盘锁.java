package LeetCode.无法归类;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/4/16 7:43 下午
 */
public class 打开转盘锁 {

    /**
     * 题目描述:
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     * <p>
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
     * 因为当拨动到 "0102" 时这个锁就会被锁定。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/open-the-lock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int openLock(String[] deadends, String target) {
        // 构建死亡密码集合
        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);
        // 构建一个队列代表广度优先访问的数据
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        q.offer(null);
        // 构建已访问过的集合
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        // 广度优先搜索
        int count = 0;
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur == null) {
                count++;
                if (q.peek() != null)
                    q.offer(null);
            } else if (cur.equals(target)) {
                return count;
            } else if (!deadSet.contains(cur)) {
                for (int i = 0; i < 4; i++) {
                    // 向前一位
                    turn(i, -1, cur, visited, q);
                    // 向后一位
                    turn(i, 1, cur, visited, q);
                }
            }
        }
        return -1;
    }

    private void turn(int idx, int add, String cur, Set<String> visited, Queue<String> q) {
        int y = ((cur.charAt(idx) - '0') + add + 10) % 10;
        String nei = cur.substring(0, idx) + ("" + y) + cur.substring(idx + 1);
        if (!visited.contains(nei)) {
            visited.add(nei);
            q.offer(nei);
        }
    }

}
