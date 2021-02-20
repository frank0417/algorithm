import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    /*
     * 题 目：二叉树的序列化与反序列化
     * 链 接: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
     * 描 述：序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     */
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null) {
            list.add(String.valueOf(root.val));
        }
        rserialize(root, list);
        return list.toString();
    }


    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        return rdeserialize(nodes, 0);
    }


    public TreeNode rdeserialize(String[] nodes, int i) {
        if (nodes == null || nodes.length == 0) return null;
        if (i > nodes.length - 1 || nodes[i].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[i]));
        while(i>1 && nodes[i-1].equals("null")){
            i--;
        }

        root.left = rdeserialize(nodes, 2 * i + 1);
        root.right = rdeserialize(nodes, 2 * i + 2);
        return root;
    }

    public void rserialize(TreeNode root, List<String> list) {

        if (root == null) return;


        if (root.left == null) {
            list.add("null");
        } else {
            list.add(String.valueOf(root.left.val));
        }

        if (root.right == null) {
            list.add("null");
        } else {
            list.add(String.valueOf(root.right.val));
        }

        rserialize(root.left, list);
        rserialize(root.right, list);

    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree b = new SerializeAndDeserializeBinaryTree();
        TreeNode t = b.deserialize("[1,2,3,null,null,4,5,6,null,null,8]");
        System.out.println(b.serialize(t));
        System.out.println("");
    }


    public String rserialize1(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize1(root.left, str);
            str = rserialize1(root.right, str);
        }
        return str;
    }

    public String serialize1(TreeNode root) {
        return rserialize1(root, "");
    }

    public TreeNode rdeserialize1(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize1(l);
        root.right = rdeserialize1(l);

        return root;
    }

    public TreeNode deserialize1(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize1(data_list);
    }

}
