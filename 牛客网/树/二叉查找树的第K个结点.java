package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 5:06 下午
 */
public class 二叉查找树的第K个结点 {

    // cost time => 4:25

    /**
     * 题目描述:
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a
     */

    private int count = 0;
    private TreeNode target;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        middle(pRoot, k);
        return target;
    }

    private void middle(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return;
        }
        middle(pRoot.left, k);
        count++;
        if (count == k) {
            target = pRoot;
            return;
        }
        middle(pRoot.right, k);
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
