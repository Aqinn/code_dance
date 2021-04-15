package LeetCode.字符串;

/**
 * @Author Aqinn
 * @Date 2021/4/15 3:17 下午
 */
public class 有效的字母异位词 {

    /**
     * 题目描述:
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        int l1 = s.length(), l2 = t.length();
        if (l1 != l2)
            return false;
        int[] memo = new int[26];
        for (int i = 0; i < l1; i++) {
            char ch = s.charAt(i);
            memo[ch - 'a']++;
        }
        for (int i = 0; i < l2; i++) {
            char ch = t.charAt(i);
            memo[ch - 'a']--;
            if (memo[ch - 'a'] < 0)
                return false;
        }
        return true;
    }

}
