package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/4/6 10:36 上午
 */
public class 丑数 {

    /**
     * 题目描述:
     * 编写一个程序判断给定的数是否为丑数。
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ugly-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <= 5) {
            return true;
        }
        while (true) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                break;
            }
        }
        return n == 1;
    }

}
