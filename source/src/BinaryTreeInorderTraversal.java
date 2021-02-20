import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /*
     * 题 目：二叉树的中序遍历
     * 链 接: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * 描 述：给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     */
    public List<Integer>inorderTraversal(TreeNode root){
       List<Integer>res=new ArrayList<>();
       inorder(root,res);
       return res;
    }

    public void inorder(TreeNode root,List<Integer>res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
