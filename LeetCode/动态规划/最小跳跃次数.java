package LeetCode.动态规划;

import java.util.*;

/**
 * @Author Aqinn
 * @Date 2021/3/28 9:49 下午
 */
public class 最小跳跃次数 {

    /**
     * 题目描述:
     * 为了给刷题的同学一些奖励，力扣团队引入了一个弹簧游戏机。
     * <p>
     * 游戏机由 N 个特殊弹簧排成一排，编号为 0 到 N-1。
     * <p>
     * 初始有一个小球在编号 0 的弹簧处。
     * <p>
     * 若小球在编号为 i 的弹簧处，通过按动弹簧，可以选择把小球向右弹射 jump[i] 的距离，或者向左弹射到任意左侧弹簧的位置。
     * <p>
     * 也就是说，在编号为 i 弹簧处按动弹簧，小球可以弹向 0 到 i-1 中任意弹簧或者 i+jump[i] 的弹簧（若 i+jump[i]>=N ，则表示小球弹出了机器）。
     * <p>
     * 小球位于编号 0 处的弹簧时不能再向左弹。
     * <p>
     * 为了获得奖励，你需要将小球弹出机器。请求出最少需要按动多少次弹簧，可以将小球从编号 0 弹簧弹出整个机器，即向右越过编号 N-1 的弹簧。
     * <p>
     * 输入：jump = [2, 5, 1, 1, 1, 1]
     * <p>
     * 输出：3
     * <p>
     * 解释：小 Z 最少需要按动 3 次弹簧，小球依次到达的顺序为 0 -> 2 -> 1 -> 6，最终小球弹出了机器。
     * <p>
     * 输入：jump = [3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7,5,1,1]
     * <p>
     * 输出：6
     * <p>
     * 输入：jump = [4,6,10,8,3,5,3,5,7,8,6,10,3,7,3,10,7,10,10,9,1,4,7,4,8,6,9,8,8,2,7,2,4,5,4,3,3,2,2,2,3,4,4,1,1,5,6,8,1,2]
     * <p>
     * 输出：11
     * <p>
     * 1 <= jump.length <= 10^6
     * <p>
     * 1 <= jump[i] <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-xiao-tiao-yue-ci-shu
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        最小跳跃次数 main = new 最小跳跃次数();
//        System.out.println(main.minJump(new int[]{2, 5, 1, 1, 1, 1}));
        System.out.println(main.minJump(new int[]{4, 6, 10, 8, 3, 5, 3, 5, 7, 8, 6, 10, 3, 7, 3, 10, 7, 10, 10, 9, 1, 4, 7, 4, 8, 6, 9, 8, 8, 2, 7, 2, 4, 5, 4, 3, 3, 2, 2, 2, 3, 4, 4, 1, 1, 5, 6, 8, 1, 2}));
    }

    /**
     * bfs的模板，下一个状态就是两种。
     * <p>
     * 一个是向前跳，一个是向后跳。
     * <p>
     * bfs每次层次遍历的时候把这两种状态入队列。
     * <p>
     * 如果向前跳的位置大于等于当前的长度就返回。
     * <p>
     * 一般来说会超时，因为你每次都是可以向后跳0-i-1个位置。
     * <p>
     * 所以这里用一个当前最大的变量记录一下，每次向后跳不把所有的入队列，只把大于之前跳过的最大值入队列。
     */
    public int minJump(int[] jump) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int maxCur = 0;
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            // 队列中有的跳法都跳一遍（全是关于这第 N 步的跳法）
            for (int i = 0; i < sz; i++) {
                Integer cur = q.poll();
                // 发现有满足条件的就直接返回，并且步数+1
                if (cur + jump[cur] >= jump.length) return step + 1;
                // 如果跳完还没到达目的地，加入下一步的待跳跳法
                if (!visited.contains(cur + jump[cur])) {
                    q.offer(cur + jump[cur]);
                    visited.add(cur + jump[cur]);
                }
                // 从已经跳过的最大下标往前跳，并且已经跳过的就不跳了（已经跳过的最大下标指的是，小于该下标的最终最远都只能跳到该下标这而已）
                for (int j = maxCur; j < cur; j++) {
                    if (!visited.contains(j)) {
                        q.offer(j);
                        visited.add(j);
                    }
                }
                // 更新 之前已经跳过的最大下标 （用于优化，否则某一弹簧前面的所有弹簧都重跳一遍会超时）
                maxCur = Math.max(maxCur, cur - 1);
            }
            step++;
        }
        return -1;
    }

    // 感觉下面这个解法没问题，但是第三个示例错了，我这里是 12 次，答案是 11 次，？？？
//    public int minJump(int[] jump) {
//        int len;
//        if (jump == null || (len = jump.length) == 0)
//            return -1;
//        return solve(jump, len - 1, 0, true);
//    }
//
//    private int solve(int[] arr, int limit, int lastLimit, boolean isFirst) {
//        // 第一根弹簧返回 0
//        if (limit == 0)
//            return 0;
//        int i = 0;
//        // 找到第一个可以跳出限制的弹簧
//        for (i = 0; i < limit; i++) {
//            if (i + arr[i] >= limit) {
//                break;
//            }
//        }
//        // 如果是最后一次弹簧了，那么超出也无所谓
//        if (isFirst) {
//            return solve(arr, i, limit, false) + 1;
//        }
//        // 如果不是最后一次弹簧，那要判断一下，如果超出了限制要判断一下需不需要往回跳
//        else {
//            // 刚好到了限制，不需要往回跳
//            if (i == limit) {
//                return solve(arr, i, limit, false) + 1;
//            }
//            // 超过了限制，但也不一定要往回跳
//            else {
//                // 如果已到达的这个位置也同时可以跳到之前的那次限制，就可以不往回跳了
//                if (i + arr[i] + arr[i + arr[i]] >= lastLimit) {
//                    return solve(arr, i, limit, false) + 1;
//                }
//                // 需要往回跳
//                else {
//                    return solve(arr, i, limit, false) + 2;
//                }
//            }
//        }
//    }

}
