package 牛客网.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/1/23 1:21 下午
 */
public class 把二叉树打印成多行 {

    // cost time => 12:24

    /**
     * 题目描述:
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288
     */

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> vals = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                vals.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
            if (vals.size() != 0) {
                list.add(vals);
            }
        }
        return list;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
