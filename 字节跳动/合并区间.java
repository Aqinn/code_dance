package 字节跳动;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author Aqinn
 * @Date 2021/2/19 4:34 下午
 */
public class 合并区间 {

    /**
     * 题目描述:
     * 给出一组区间，请合并所有重叠的区间。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a
     */

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        Iterator<Interval> it = intervals.iterator();
        Interval pre = null;
        while (it.hasNext()) {
            if (pre == null) {
                pre = it.next();
                continue;
            }
            Interval cur = it.next();
            if (pre.end >= cur.start) {
                pre.end = Math.max(pre.end, cur.end);
                it.remove();
            } else {
                pre = cur;
            }
        }
        return intervals;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
