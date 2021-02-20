import java.util.HashMap;
import java.util.Map;

public class MaximumDepthOfBinaryTree {
    /*
     * 题 目：二叉树的最大深度
     * 链 接: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * 描 述：给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */

    Map<Integer, Integer> map = new HashMap<>();

    public int maxDepth(TreeNode root) {
        int depth = 0;
        depth(root, depth);
        return map.size();
    }

    public void depth(TreeNode root, int depth) {
        if (root == null) return;
        if (map.size() == depth) {
            map.put(depth, depth);
        }
        if (root.left != null) {
            depth(root.left, depth + 1);
        }
        if (root.right != null) {
            depth(root.right, depth + 1);
        }
    }


    public int maxDepth1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root == null ? 0 : 1;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;


    }
}
