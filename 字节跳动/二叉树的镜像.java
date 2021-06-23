package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 9:48 上午
 */
public class 二叉树的镜像 {

    /**
     * 题目描述:
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7
     */

    public TreeNode Mirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
        return root;
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
