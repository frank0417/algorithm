import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTrderAndInorderTraversal {
    /*
     * 题 目：从前序与中序遍历序列构造二叉树
     * 链 接: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * 描 述：根据一棵树的前序遍历与中序遍历构造二叉树。
     */
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; ++i) map.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd ) return null;
        int inRootIndex=map.get(preorder[pStart]);
        int leftLength=inRootIndex-iStart;
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = buildTree(preorder, pStart + 1, pStart+leftLength, inorder, iStart, inRootIndex - 1);
        root.right = buildTree(preorder, pStart+leftLength+ 1, pEnd, inorder, inRootIndex + 1, iEnd);
        return root;
    }
}
