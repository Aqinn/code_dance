package 字节跳动;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Aqinn
 * @Date 2021/2/3 12:20 下午
 */
public class 二叉树的右视图 {

    /**
     * 题目描述:
     * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || zhongxu == null)
            return null;
        TreeNode root = buildTree(xianxu, zhongxu, 0, 0, xianxu.length);
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int val = -1;
            while (size-- > 0) {
                TreeNode temp = q.poll();
                if (temp == null)
                    continue;
                q.add(temp.left);
                q.add(temp.right);
                val = temp.val;
            }
            if (val != -1)
                list.add(val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public TreeNode buildTree(int[] xianxu, int[] zhongxu, int rootIdx, int zxStart, int len) {
        if (len <= 0)
            return null;
        TreeNode root = null;
        for (int i = zxStart; i < zxStart + len; i++) {
            if (xianxu[rootIdx] == zhongxu[i]) {
                root = new TreeNode(xianxu[rootIdx]);
                root.left = buildTree(xianxu, zhongxu,
                        rootIdx + 1, zxStart, i - zxStart);
                root.right = buildTree(xianxu, zhongxu,
                        rootIdx + i - zxStart + 1, i + 1, zxStart + len - i - 1);
                return root;
            }
        }
        return root;
    }

    private class TreeNode {
        int val = -1;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int v) {
            val = v;
        }
    }


}
