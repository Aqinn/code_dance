package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/17 3:04 下午
 */
public class 将字符串转化成整数 {

    /**
     * 题目描述:
     * 实现函数 atoi 。函数的功能为将字符串转化为整数
     * 提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/44d8c152c38f43a1b10e168018dcc13f
     */

    /**
     * @param str string字符串
     * @return int整型
     */
    public int atoi(String str) {
        int errorInt = -1;
        str = str.replaceAll(" ", "");
        int len = str.length();
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if (c == '-') {
                    flag = true;
                    continue;
                } else if (c == '+') {
                    continue;
                }
            }
            if (!isDigit(c)) {
                return flag ? -res : res;
            }
            if (isOutOf(res, c, flag)) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + c2i(c);
        }
        return flag ? -res : res;
    }

    private boolean isOutOf(int res, char c, boolean flag) {
        if (!flag) {
            if (res > Integer.MAX_VALUE / 10) {
                return true;
            }
            return res == Integer.MAX_VALUE / 10 && c2i(c) > Integer.MAX_VALUE % 10;
        } else {
            if (-res < (Integer.MIN_VALUE / 10)) {
                return true;
            }
            return -res == (Integer.MIN_VALUE / 10) && c2i(c) > -(Integer.MIN_VALUE % 10);
        }
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private int c2i(char c) {
        return c - '0';
    }

}
