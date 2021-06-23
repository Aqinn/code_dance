package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/25 9:32 上午
 */
public class 正则表达式匹配 {

    /**
     * 题目描述:
     * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。
     * 模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4
     */

    public static void main(String[] args) {
        正则表达式匹配 main = new 正则表达式匹配();
        System.out.println(main.match(
                new char[]{'a', 'a'},
                new char[]{'a', '*', '*'}
        ));
    }

    public boolean match(char[] str, char[] pattern) {
        return isMatch(str, 0, pattern, 0);
    }

    private boolean isMatch(char[] str, int sIdx, char[] pattern, int pIdx) {
        if (sIdx == str.length && pIdx == pattern.length) {
            return true;
        }
        if (pIdx == pattern.length) {
            return false;
        }
        // 进来以后就肯定是正则表达式还没结束，但字符串可能已经结束了
        boolean next = (pIdx + 1 < pattern.length && pattern[pIdx + 1] == '*');
        if (next) {
            if (sIdx < str.length && (pattern[pIdx] == '.' || str[sIdx] == pattern[pIdx])) {
                return isMatch(str, sIdx, pattern, pIdx + 2) || isMatch(str, sIdx + 1, pattern, pIdx);
            } else {
                return isMatch(str, sIdx, pattern, pIdx + 2);
            }
        } else {
            if (sIdx < str.length && (pattern[pIdx] == '.' || str[sIdx] == pattern[pIdx])) {
                return isMatch(str, sIdx + 1, pattern, pIdx + 1);
            } else {
                return false;
            }
        }
    }

}
