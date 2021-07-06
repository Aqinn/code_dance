package LeetCode.树

import java.util.*

/**
 * @Author Aqinn
 * @Date 2021/7/6 11:23 下午
 */

/*
题目描述:
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：2

示例 2：
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

提示：
树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val q = LinkedList<TreeNode?>()
    var floor = 1
    q.offer(root)
    while (q.isNotEmpty()) {
        var size = q.size
        while (size-- > 0) {
            val poll = q.poll() ?: continue
            if (poll.left == null && poll.right == null) {
                return floor
            }
            q.offer(poll.left)
            q.offer(poll.right)
        }
        floor++
    }
    return floor
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}