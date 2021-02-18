package 字节跳动;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/2/18 10:56 上午
 */
public class 括号生成 {

    /**
     * 题目描述:
     * 给出 n 对括号，请编写一个函数来生成所有的由 n 对括号组成的合法组合。
     * 例如，给出 n=3，解集为：
     * "((()))", "(()())", "(())()", "()()()", "()(())",
     */

    // 按题目顺序输出
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }

    private void backtrack(String str, int open, int close, int count, List<String> res){
        if (str.length() == count << 1){
            res.add(str);
            return;
        }
        if (open < count){
            backtrack(str + "(", open+1, close, count, res);
        }
        if (close < open){
            backtrack(str + ")", open, close+1, count, res);
        }
    }

    // 没有按题目顺序输出
    public ArrayList<String> _generateParenthesis (int n) {
        ArrayList<String> res = new ArrayList<>();
        gen("", 0, n, res);
        return res;
    }
    private void gen(String cur, int idx, int count, ArrayList<String> res){
        if(count == 0){
            if(!res.contains(cur))
                res.add(cur);
            return ;
        }
        gen(
                cur.substring(0, idx) + "()" + cur.substring(idx, cur.length()),
                idx+1,
                count-1,
                res
        );
        gen(
                cur.substring(0, idx) + "()" + cur.substring(idx, cur.length()),
                idx,
                count-1,
                res
        );
        gen(
                cur.substring(0, idx) + "()" + cur.substring(idx, cur.length()),
                idx+2,
                count-1,
                res
        );
    }

}
