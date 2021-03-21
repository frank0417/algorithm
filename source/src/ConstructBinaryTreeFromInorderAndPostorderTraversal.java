import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /*
     * 题 目：从中序与后序遍历序列构造二叉树
     * 链 接: https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * 描 述：根据一棵树的中序遍历与后序遍历构造二叉树。
     */

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        for (int i = 0; i < inorder.length; ++i) map.put(inorder[i], i);
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int lstart, int lend, int[] postorder, int rstart, int rend) {
        if (lstart > lend || rstart > rend) return null;
        TreeNode root = new TreeNode();
        root.val = postorder[rend];
        int rootIndex = map.get(root.val);
        int leftLength = rootIndex - lstart;

        root.left = buildTree(inorder, lstart, rootIndex - 1, postorder, rstart, rstart + leftLength - 1);
        root.right = buildTree(inorder, rootIndex + 1, lend, postorder, rstart + leftLength, rend - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal con = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode treeNode = con.buildTree(new int[]{1,2,3,4,5,6,7}, new int[]{1,3,2,6,5,7,4});
        System.out.println(treeNode.toString());
    }

}
