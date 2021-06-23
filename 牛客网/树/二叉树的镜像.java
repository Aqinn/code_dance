package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 12:15 下午
 */
public class 二叉树的镜像 {

    // cost time => 1:34

    /**
     * 题目描述:
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7
     */

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
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
