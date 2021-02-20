import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

    /*
     * 题 目：N叉树的后序遍历
     * 链 接: https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
     * 描 述：给定一个 N 叉树，返回其节点值的后序遍历。
     */
    public List<Integer> postorder(Node node) {
        List<Integer> res = new ArrayList<>();
        order(node, res);
        return res;
    }

    public void order(Node node, List<Integer> res) {
        if (node == null) return;
        for (Node n : node.children) {
            order(n, res);
        }
        res.add(node.val);
    }
}
