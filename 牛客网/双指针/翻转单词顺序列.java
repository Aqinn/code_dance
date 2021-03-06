package 牛客网.双指针;

/**
 * @Author Aqinn
 * @Date 2021/1/21 5:26 下午
 */
public class 翻转单词顺序列 {

    // cost time => 25:38

    /**
     * 题目描述:
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。
     * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        翻转单词顺序列 main = new 翻转单词顺序列();
        System.out.println(main.ReverseSentence(""));
    }

    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, idx, i - 1);
                idx = i + 1;
            }
            if (i == chars.length - 1) {
                reverse(chars, idx, chars.length - 1);
            }
        }
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        if (start >= end) {
            return;
        }
        for (int i = start; i <= (start + end) / 2; i++) {
            swap(chars, i, end - i + start);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

}
