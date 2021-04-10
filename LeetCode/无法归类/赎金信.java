package LeetCode.无法归类;

/**
 * @Author Aqinn
 * @Date 2021/4/10 10:53 下午
 */
public class 赎金信 {

    /**
     * 题目描述:
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     */

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null)
            return false;
        int[] memo = new int[26];
        int l1 = ransomNote.length(), l2 = magazine.length();
        for (int i = 0; i < l2; i++) {
            memo[char2Int(magazine.charAt(i))]++;
        }
        for (int i = 0; i < l1; i++) {
            int c = char2Int(ransomNote.charAt(i));
            if (memo[c] <= 0)
                return false;
            memo[c]--;
        }
        return true;
    }

    private int char2Int(char ch) {
        if ('a' <= ch && ch <= 'z')
            return ch - 'a';
        else
            return 0;
    }

}
