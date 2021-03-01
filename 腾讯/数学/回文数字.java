package 腾讯.数学;

/**
 * @Author Aqinn
 * @Date 2021/3/1 8:24 下午
 */
public class 回文数字 {

    /**
     * 题目描述:
     * 在不使用额外的内存空间的条件下判断一个整数是否是回文数字
     * 提示：
     * 负整数可以是回文吗？（比如 - 1）
     * 如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
     * 你可以将整数翻转。但是，如果你做过题目 “反转数字”，你会知道将整数 翻转可能会出现溢出的情况，你怎么处理这个问题？
     */

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

}
