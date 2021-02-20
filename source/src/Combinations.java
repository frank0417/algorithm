import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {
    /*
     * 题 目：组合
     * 链 接: https://leetcode-cn.com/problems/combinations/
     * 描 述：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, 1, dq, result);
        return result;
    }

    private void dfs(int n, int k, int start, Deque<Integer> dq, List<List<Integer>> result) {
        if (dq.size() == k) {
            result.add(new ArrayList<Integer>(dq));
            return;
        }
        for (int i = start; i <= n-k+dq.size()+1; ++i) {
            dq.addLast(i);
            dfs(n, k, i + 1, dq, result);
            dq.removeLast();
        }

    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> list = combinations.combine(4, 2);
        System.out.println(list.toString());
    }
}
