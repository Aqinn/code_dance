package 牛客网.搜索;

/**
 * @Author Aqinn
 * @Date 2021/3/5 11:16 下午
 */
public class KMP算法 {

    /**
     * 题目描述:
     * 给你一个非空模板串S，一个文本串T，问S在T中出现了多少次
     * 空间O(n)时间O(n)的算法
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/bb1615c381cc4237919d1aa448083bcc
     */

    public int kmp(String S, String T) {
        if (T == null || T.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= T.length() - S.length(); i++) {
            if (match(S, T, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean match(String S, String T, int idx) {
        if (S.length() > T.length() - idx) {
            return false;
        }
        for (int i = idx; i < S.length() + idx; i++) {
            if (S.charAt(i - idx) != T.charAt(i)) {
                return false;
            }
            if (i - idx == S.length() - 1) {
                return true;
            }
        }
        return false;
    }

}
