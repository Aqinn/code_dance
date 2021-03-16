package 快手.字符串;

/**
 * @Author Aqinn
 * @Date 2021/3/16 10:46 下午
 */
public class 最长公共前缀 {

    /**
     * 题目描述:
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     */

    public String longestCommonPrefix(String[] strs) {
        int len;
        if (strs == null || (len = strs.length) == 0)
            return "";
        if (len == 1)
            return strs[0];
        StringBuilder sb = new StringBuilder();
        for (int cur = 0; cur < strs[0].length(); cur++) {
            char first = strs[0].charAt(cur);
            boolean flag = false;
            for (int i = 1; i < len; i++) {
                if (cur < strs[i].length() && strs[i].charAt(cur) == first) {
                    continue;
                }
                flag = true;
                break;
            }
            if (flag) {
                break;
            }
            sb.append(first);
        }
        return sb.toString();
    }

}
