package 字节跳动;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author Aqinn
 * @Date 2021/3/21 8:41 下午
 */
public class 最小覆盖子串 {

    /**
     * 题目描述:
     * 给出两个字符串 SS 和 TT，要求在O(n)O(n)的时间复杂度内在 SS 中找出最短的包含 TT 中所有字符的子串。
     * 例如：
     * <p>
     * S ="XDOYEZODEYXNZ"S="XDOYEZODEYXNZ"
     * T ="XYZ"T="XYZ"
     * 找出的最短子串为"YXNZ""YXNZ".
     * <p>
     * 注意：
     * 如果 SS 中没有包含 TT 中所有字符的子串，返回空字符串 “”；
     * 满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。
     */

    public static void main(String[] args) {
        最小覆盖子串 main = new 最小覆盖子串();
        System.out.println(main.minWindow("XDOYEZODEYXNZ", "XYZ"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }

    private void show(Map<Character, Integer> map) {
        System.out.println("============= map show =============");
        map.entrySet().parallelStream().forEach(new Consumer<Map.Entry<Character, Integer>>() {
            @Override
            public void accept(Map.Entry<Character, Integer> e) {
                System.out.println(e.getKey() + " : " + e.getValue());
            }
        });
        System.out.println("============ map show end ==========");
    }

}
