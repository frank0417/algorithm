import java.util.ArrayList;
import java.util.List;

public class NaryTreePretorderTraversal {
    /*
     * 题 目：N叉树的前序遍历
     * 链 接: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
     * 描 述：给定一个 N 叉树，返回其节点值的前序遍历。
     */
    public List<Integer> preorder(Node node) {
        List<Integer> res = new ArrayList<>();
        order(node, res);
        return res;
    }

    public void order(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        for (Node n : node.children) {
            order(n, res);
        }
    }
}
