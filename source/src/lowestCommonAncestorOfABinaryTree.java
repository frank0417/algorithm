public class lowestCommonAncestorOfABinaryTree {
    /*
     * 题 目：二叉树的最近公共祖先
     * 链 接: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * 描 述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null && right != null) return right;
        if (right == null && left != null) return left;
        return root;
    }
}
