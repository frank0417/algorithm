import java.util.*;

public class Permutations {
    /*
     * 题 目：全排列
     * 链 接: https://leetcode-cn.com/problems/permutations/
     * 描 述：给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     */

    public List<List<Integer>> permute(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dsp(nums, len, used, dq, result);
        return result;
    }

    private void dsp(int[] nums, int len, boolean[] used, Deque<Integer> dq, List<List<Integer>> result) {
        if (dq.size() == len) {
            result.add(new ArrayList<>(dq));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            dq.addLast(nums[i]);
            used[i] = true;
            dsp(nums, len, used, dq, result);
            used[i] = false;
            dq.removeLast();
        }
    }


}
