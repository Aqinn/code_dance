package 牛客网.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/1/23 1:34 下午
 */
public class 按之字形顺序打印二叉树 {

    // cost time => 23:22

    /**
     * 题目描述:
     * 请实现一个函数按照之字形打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
     * 其他行以此类推。
     */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = true;  // true代表从左到右输出，如果该行是从左到右输出，那么就应该从右往左存入Queue
        while (!queue.isEmpty()) {
            // 要输出的节点个数
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp == null)
                    continue;
                if (flag)
                    list.add(temp.val);
                else
                    list.add(0, temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
            if (list.size() != 0) {
                flag = !flag;
                res.add(list);
            }
        }
        return res;
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
