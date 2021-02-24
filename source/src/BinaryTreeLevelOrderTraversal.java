import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /*
     * 题 目：二叉树的层序遍历
     * 链 接: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 描 述：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        bfs(0, root, result);
        return result;
    }

    public void bfs(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null) return;
        if (level == result.size()) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        bfs(level + 1, root.left, result);
        bfs(level + 1, root.right, result);
    }

    //非递归实现
    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = dq.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = dq.poll();
                list.add(node.val);
                if (node.left != null) dq.add(node.left);
                if (node.right != null) dq.add(node.right);
            }
            result.add(list);
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        TreeNode ll2 = new TreeNode(31);
        TreeNode lr2 = new TreeNode(32);
        TreeNode ll1 = new TreeNode(21, ll2, lr2);
        TreeNode lr1 = new TreeNode(22);
        TreeNode root = new TreeNode(1, ll1, lr1);
        b.levelOrderII(root);
    }
}
