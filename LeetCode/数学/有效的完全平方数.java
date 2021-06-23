package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/1 9:12 上午
 */
public class 有效的完全平方数 {

    /**
     * 题目描述:
     * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * <p>
     * 进阶：不要 使用任何内置的库函数，如 sqrt 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-perfect-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        有效的完全平方数 main = new 有效的完全平方数();
        System.out.println(main.isPerfectSquare(808201));
    }

    // 会溢出... 要用long！
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true;
        long l = 2, r = num / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long temp = mid * mid;
            if (temp == num)
                return true;
            if (temp > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
