package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 2:19 下午
 */
public class 判断回文 {

    /**
     * 题目描述:
     * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2
     */

    public boolean judge(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        int l=0, r=str.length()-1;
        while(l < r){
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
