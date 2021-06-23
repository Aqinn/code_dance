package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 11:19 上午
 */
public class 树的子结构 {

    // cost time => 17:42

    /**
     * 题目描述:
     * 输入两棵二叉树A，B，判断B是不是A的子结构。
     * （ps：我们约定空树不是任意一个树的子结构）
     *
     * 来源：牛客
     * 链接：
     */


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return check(root1, root2);
    }

    public boolean check(TreeNode root1,TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root2.val == root1.val) {
            if (check(root1.left, root2.left) && check(root1.right, root2.right)) {
                return true;
            } else {
                return check(root1.left, root2) || check(root1.right, root2);
            }
        } else {
            return check(root1.left, root2) || check(root1.right, root2);
        }
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
