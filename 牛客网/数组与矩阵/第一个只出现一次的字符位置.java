package 牛客网.数组与矩阵;

/**
 * @Author Aqinn
 * @Date 2021/1/21 2:40 下午
 */
public class 第一个只出现一次的字符位置 {

    // cost time => 3:41

    /**
     * 题目描述:
     * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
     * <p>
     * Input: abacc
     * <p>
     * Output: b
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c
     */

    public static void main(String[] args) {
        String str = "abcalbkj";
        System.out.println(getFirstRepeat(str));
    }

    private static int getFirstRepeat(String str) {
        int[] idx = new int[128];
        for (int i = 0; i < str.length(); i++) {
            idx[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (idx[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }


}
