package 牛客网.数组与矩阵;

/**
 * @Author Aqinn
 * @Date 2021/1/21 1:53 下午
 */
public class 替换空格 {

    /**
     * 题目描述:
     * 将一个字符串中的空格替换成 "%20"。
     * <p>
     * Input:
     * "A B"
     * <p>
     * Output:
     * "A%20B"
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        String str = " ha lo ";
        System.out.println(replaceSpace(str));
    }

    private static String replaceSpace(String str){
        StringBuffer sb = new StringBuffer(str);
        int p1 = sb.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int p2 = sb.length() - 1;
        while (p1 < p2 && p1 >= 0) {
            char c = sb.charAt(p1--);
            if (c == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            } else {
                sb.setCharAt(p2--, c);
            }
        }
        return sb.toString();
    }

}
