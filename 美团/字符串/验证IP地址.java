package 美团.字符串;

/**
 * @Author Aqinn
 * @Date 2021/3/8 11:08 下午
 */
public class 验证IP地址 {

    /**
     * 题目描述:
     * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
     *
     * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
     * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
     *
     * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
     *
     * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
     * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
     *
     * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
     */

    /**
     * 验证IP地址
     *
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve(String IP) {
        int len;
        if (IP == null || (len = IP.length()) == 0)
            return "Neither";
        if (isIPv4(IP))
            return "IPv4";
        if (isIPv6(IP))
            return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String ip) {
        if (ip == null)
            return false;
        String[] chs = ip.split("\\.");
        int len = chs.length;
        if (len != 4)
            return false;
        for (int i = 0; i < len; i++) {
            if (!verify4(chs[i]))
                return false;
            if (i == len - 1)
                return true;
        }
        return false;
    }

    private boolean verify4(String str) {
        int len;
        if (str == null || (len = str.length()) == 0)
            return false;
        if (str.charAt(0) == '0' && len != 1) {
            return false;
        } else {
            int i = Integer.parseInt(str);
            return 0 <= i && i <= 255;
        }
    }

    private boolean isIPv6(String ip) {
        if (ip == null)
            return false;
        String[] chs = ip.split(":");
        int len = chs.length;
        if (len != 8)
            return false;
        for (int i = 0; i < len; i++) {
            if (!verify6(chs[i]))
                return false;
            if (i == len - 1)
                return true;
        }
        return false;
    }

    private boolean verify6(String str) {
        int len;
        if (str == null || (len = str.length()) == 0)
            return false;
        if (is16(str)) {
            int i = Integer.parseInt(str, 16);
            if (i == 0 && len != 1)
                return false;
            return 0 <= i && i <= 65535;
        } else {
            return false;
        }
    }

    private boolean is16(String str) {
        int len;
        if (str == null || (len = str.length()) == 0)
            return false;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (('0' <= ch && ch <= '9') ||
                    ('a' <= ch && ch <= 'f') ||
                    ('A' <= ch && ch <= 'F'))
                continue;
            else
                return false;
        }
        return true;
    }

}
