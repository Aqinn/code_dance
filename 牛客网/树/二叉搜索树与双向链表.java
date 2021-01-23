package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 3:15 下午
 */
public class 二叉搜索树与双向链表 {

    /**
     * 题目描述:
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */

    private TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        // 找到最左节点，当做pre
        Convert(pRootOfTree.left);
        if (pre != null) {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        // 此最左节点的右子树的最左节点
        Convert(pRootOfTree.right);
        return pre;
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
