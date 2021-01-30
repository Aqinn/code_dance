package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 4:27 下午
 */
public class 分别按照二叉树先序和中序和后序打印所有的节点 {

    /**
     * 题目描述:
     * 如类名
     */

    public int[][] threeOrders (TreeNode root) {
        int[][] res = new int[3][count(root)];
        pre(res[0], root);
        mid(res[1], root);
        back(res[2], root);
        return res;
    }

    private int count(TreeNode root){
        if(root == null)
            return 0;
        return count(root.left) + count(root.right) + 1;
    }

    private int preIdx=0;
    private void pre(int[] res,  TreeNode node){
        if (node == null)
            return;
        res[preIdx++] = node.val;
        pre(res, node.left);
        pre(res, node.right);
    }

    private int midIdx=0;
    private void mid(int[] res,  TreeNode node){
        if (node == null)
            return;
        mid(res, node.left);
        res[midIdx++] = node.val;
        mid(res, node.right);
    }

    private int backIdx=0;
    private void back(int[] res,  TreeNode node){
        if (node == null)
            return;
        back(res, node.left);
        back(res, node.right);
        res[backIdx++] = node.val;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
