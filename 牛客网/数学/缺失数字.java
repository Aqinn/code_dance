package 牛客网.数学;

/**
 * @Author Aqinn
 * @Date 2021/2/22 9:33 下午
 */
public class 缺失数字 {

    /**
     * 题目描述:
     * 从 0,1,2,...,n 这 n+1 个数中选择 n 个数，组成有序数组，请找出缺失的那个数，要求 O (n) 尽可能小。
     */

    /**
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        int len = a.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        return len * (len + 1) / 2 - sum;
    }

    public int __solve(int[] a) {
        int len = a.length;
        int res = len;
        for (int i = 0; i < len; i++) {
            res ^= i ^ a[i];
        }
        return res;
    }

    public int _solve(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (i != a[i])
                return i;
        }
        return len;
    }

}
