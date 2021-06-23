package 腾讯.字符串;

/**
 * @Author Aqinn
 * @Date 2021/3/12 2:03 下午
 */
public class 比较版本号 {

    /**
     * 题目描述:
     * 如果version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
     * 输入的version字符串非空，只包含数字和字符.。.字符不代表通常意义上的小数点，只是用来区分数字序列。
     * 例如字符串2.5并不代表二点五，只是代表版本是第一级版本号是2，第二级版本号是5.
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/2b317e02f14247a49ffdbdba315459e7
     */

    public int compare(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.min(s1.length, s2.length);
        for (int i = 0; i < len; i++) {
            if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])) {
                return 1;
            } else if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) {
                return -1;
            }
        }
        if (s1.length > s2.length) {
            return 1;
        } else if (s1.length < s2.length) {
            return -1;
        }
        return 0;
    }

}
