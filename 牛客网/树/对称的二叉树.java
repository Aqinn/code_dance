package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 12:18 下午
 */
public class 对称的二叉树 {

    // cost time => 9:57

    /**
     * 题目描述:
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/1b0b7f371eae4204bc4a7570c84c2de1
     */

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
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
