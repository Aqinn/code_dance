package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 2:19 下午
 */
public class 判断回文 {

    /**
     * 题目描述:
     * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
     */

    public boolean judge(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        int l=0, r=str.length()-1;
        while(l < r){
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}
