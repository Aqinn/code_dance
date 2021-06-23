package 牛客网.栈队列堆;

/**
 * @Author Aqinn
 * @Date 2021/1/21 4:09 下午
 */
public class 字符流中第一个不重复的字符 {

    /**
     * 题目描述:
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
     * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        字符流中第一个不重复的字符 main = new 字符流中第一个不重复的字符();
        main.Insert('g');
        main.Insert('o');
        System.out.println(main.FirstAppearingOnce());
        main.Insert('o');
        main.Insert('g');
        main.Insert('l');
        main.Insert('e');
        System.out.println(main.FirstAppearingOnce());
    }

    private int[] arr = new int[128];
    private char[] chars = new char[1000];
    private int size = 0;

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        arr[ch]++;
        chars[size++] = ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0; i<size; i++){
            if (arr[chars[i]] == 1) {
                return chars[i];
            }
        }
        return '#';
    }

}
