package LeetCode.数学;

/**
 * @Author Aqinn
 * @Date 2021/3/24 1:42 下午
 */
public class 位1的个数 {

    /**
     * 题目描述:
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * 简而言之，二进制中1的个数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-1-bits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        System.out.println(new 位1的个数().hammingWeight(11));
    }

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
//            if((n & 1) == 1)
//                count++;
//            n >>= 1;
            n &= n - 1;
            count++;
        }
        return count;
    }

}
