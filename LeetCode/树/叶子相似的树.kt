package LeetCode.树

/**
 * @Author Aqinn
 * @Date 2021/5/7 10:26 上午
 */
class 叶子相似的树 {

    /**
     * 题目描述:
     * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * <p>
     * <img width="640" height="200" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png" alt="">
     * <p>
     * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
     * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null || root2 == null)
            return false
        val root1Children = mutableListOf<TreeNode>()
        getChildren(root1, root1Children)
        val root2Children = mutableListOf<TreeNode>()
        getChildren(root2, root2Children)
        if (root1Children.size != root2Children.size)
            return false
        for (i in root1Children.indices) {
            if (root1Children.get(i).`val` != root2Children.get(i).`val`)
                return false
        }
        return true
    }

    fun getChildren(root: TreeNode, res: MutableList<TreeNode>) {
        if (root.left == null && root.right == null) {
            res.add(root)
            return
        }
        if (root.left != null)
            getChildren(root.left!!, res)
        if (root.right != null)
            getChildren(root.right!!, res)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}