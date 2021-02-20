import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /*
     * 题 目：二叉树的层序遍历
     * 链 接: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 描 述：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>>res=new ArrayList<>();
        levelOrder(root,0,res);
        return  res;
    }

    public void levelOrder(TreeNode root,Integer level,List<List<Integer>>res){
        if(root==null)return;

        if(res.size()==level){
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(root.val);

        if(root.right!=null){
            levelOrder(root.right,level+1,res);
        }
        if(root.left!=null){
            levelOrder(root.left,level+1,res);
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b=new BinaryTreeLevelOrderTraversal();
        TreeNode ll2=new TreeNode(31);
        TreeNode lr2=new TreeNode(32);
        TreeNode ll1=new TreeNode(21,ll2,lr2);
        TreeNode lr1=new TreeNode(22);
        TreeNode root=new TreeNode(1,ll1,lr1);
        b.levelOrderTraversal(root);
    }
}
