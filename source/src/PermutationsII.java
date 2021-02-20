import java.util.*;

public class PermutationsII {
    /*
     * 题 目：全排列 II
     * 链 接: https://leetcode-cn.com/problems/permutations-ii/
     * 描 述：给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
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
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i-1]==false)) {
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
