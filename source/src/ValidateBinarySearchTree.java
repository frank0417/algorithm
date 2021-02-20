public class ValidateBinarySearchTree {
    /*
     * 题 目：验证二叉搜索树
     * 链 接：https://leetcode-cn.com/problems/validate-binary-search-tree/
     * 描 述：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recur(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return recur(root.left, lower, root.val) && recur(root.right, root.val, upper);
    }


    public static void main(String[] args) {
        TreeNode right1l = new TreeNode(3);
        TreeNode right1r = new TreeNode(6);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4, right1l, right1r);
        TreeNode root = new TreeNode(2147483647, null, null);
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        v.isValidBST(root);

    }
}
