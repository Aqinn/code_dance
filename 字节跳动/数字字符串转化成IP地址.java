package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/2/17 4:18 下午
 */
public class 数字字符串转化成IP地址 {

    /**
     * 题目描述:
     * 现在有一个只包含数字的字符串，将该字符串转化成 IP 地址的形式，返回所有可能的情况。
     */

    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        getIP(s, 0, 3, res);
        return res;
    }

    private void getIP(String cur, int idx, int count, ArrayList<String> res) {
        if (count == 0) {
            String[] sp = cur.split("\\.");
            if (sp.length < 4) return;
            for (String str : sp) {
                if (str.length() > 1 && str.charAt(0) == '0') return;
                if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) return;
            }
            res.add(cur);
            return;
        }
        int len = cur.length();
        if (idx >= len)
            return;
        // 增加一位
        getIP(cur.substring(0, idx + 1) + "." + cur.substring(idx + 1, len), idx + 2, count - 1, res);
        // 增加两位
        if (len - 2 > idx)
            getIP(cur.substring(0, idx + 2) + "." + cur.substring(idx + 2, len), idx + 3, count - 1, res);
        // 增加三位
        if (len - 3 > idx)
            getIP(cur.substring(0, idx + 3) + "." + cur.substring(idx + 3, len), idx + 4, count - 1, res);
    }

}
