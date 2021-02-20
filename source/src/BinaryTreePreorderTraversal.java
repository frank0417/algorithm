import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    /*
     * 题 目：二叉树的前序遍历
     * 链 接: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * 描 述：给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
