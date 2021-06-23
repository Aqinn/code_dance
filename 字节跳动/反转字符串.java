package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/31 11:10 上午
 */
public class 反转字符串 {

    /**
     * 题目描述:
     * 反转字符串
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3
     */

    public String solve(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str)) {
            return "";
        }
        int i = 0, j = str.length() - 1;
        char[] arr = str.toCharArray();
        while (i < j) {
            swap(arr, i++, j--);
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
