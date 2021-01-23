package 牛客网.树;

/**
 * @Author Aqinn
 * @Date 2021/1/23 4:37 下午
 */
public class 序列化二叉树 {

    // cost time => 25:10

    /**
     * 题目描述:
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     * <p>
     * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
     * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
     * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
     * <p>
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     * <p>
     * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
     */

    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    private String deserializeStr;

    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        // 获得一个节点值的结束下标
        int index = deserializeStr.indexOf(" ");
        // 或者该节点的值。PS：找不到" "的下标证明这是最后一个值了，最后没有“ ”
        String strVal = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 找到了值以后，修改 deserializeStr
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if ("#".equals(strVal))
            return null;
        int intVal = Integer.valueOf(strVal);
        TreeNode temp = new TreeNode(intVal);
        temp.left = Deserialize();
        temp.right = Deserialize();
        return temp;
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
