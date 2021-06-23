package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 3:53 下午
 */
public class 进制转换 {

    /**
     * 题目描述:
     * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1
     */

    public String solve(int M, int N) {
        // write code here
        if (M == 0) {
            return "0";
        }
        boolean fu = false;
        if (M < 0){
            fu = true;
            M = -M;
        }
        String sign = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        while (M != 0){
            sb.append(sign.charAt(M%N));
            M /= N;
        }
        if (fu) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

}
