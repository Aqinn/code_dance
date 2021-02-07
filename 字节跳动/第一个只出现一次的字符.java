package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/7 11:48 下午
 */
public class 第一个只出现一次的字符 {

    /**
     * 题目描述:
     * 在一个字符串 (0<= 字符串长度 <=10000，全部由字母组成) 中找到第一个只出现一次的字符，并返回它的位置，
     * 如果没有则返回 -1（需要区分大小写）.（从 0 开始计数）
     */

    public int FirstNotRepeatingChar(String str) {
        if (str == null || "".equals(str))
            return -1;
        int[] arr = new int[128];
        char[] chs = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            arr[chs[i]]++;
        }
        for(int i=0; i<str.length(); i++){
            if( arr[chs[i]] == 1 )
                return i;
        }
        return -1;
    }

}
