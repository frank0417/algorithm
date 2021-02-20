public class MinimumDepthOfBinaryTree {
    /*
     * 题 目：二叉树的最小深度
     * 链 接: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     * 描 述：给定一个二叉树，找出其最小深度。
     *       最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *       叶子节点是指没有子节点的节点。
     */

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return recur(root, 1);
    }

    public int recur(TreeNode root, int level) {
        if (root == null) return level;
        if (root.left == null && root.right == null) return level;
        int leftLevel = Integer.MAX_VALUE, rightLevel = Integer.MAX_VALUE;
        if (root.left != null) {
            leftLevel = recur(root.left, level + 1);
        }
        if (root.right != null) {
            rightLevel = recur(root.right, level + 1);
        }
        return Math.min(leftLevel, rightLevel);
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int L = minDepth(root.left), R = minDepth(root.right), m = Math.min(L, R);
        return 1 + (m > 0 ? m : Math.max(L, R));
    }
}
