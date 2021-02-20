public class InvertBinaryTree {
    /*
     * 题 目：翻转二叉树
     * 链 接：https://leetcode-cn.com/problems/invert-binary-tree/
     * 描 述：翻转一棵二叉树。
     */
    public TreeNode invertTree(TreeNode root) {
        recur(root);
        return root;
    }

    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;

        recur(root.left);
        recur(root.right);
    }


}
