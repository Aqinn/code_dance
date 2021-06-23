package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/11 2:49 下午
 */
public class 二叉搜索树与双向链表 {

    /**
     * 题目描述:
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
     */

    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.right);
        if (pre != null) {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.left);
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
