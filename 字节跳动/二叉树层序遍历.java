package 字节跳动;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/1/30 5:28 下午
 */
public class 二叉树层序遍历 {

    /**
     * 题目描述:
     * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     * 例如：
     * 给定的二叉树是{3,9,20,#,#,15,7},
     * <p>
     * 该二叉树层序遍历的结果是
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            while(size-- > 0){
                TreeNode temp = q.poll();
                if(temp == null)
                    continue;
                list.add(temp.val);
                q.add(temp.left);
                q.add(temp.right);
            }
            if (list.size() != 0)
                res.add(list);
        }
        return res;
    }

}
