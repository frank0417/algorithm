import java.util.*;

public class Subsets {
    /*
     * 题 目：子集
     * 链 接: https://leetcode-cn.com/problems/subsets/
     * 描 述：给你一个整数数组 nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。
     *       解集不能包含重复的子集。你可以按任意顺序返回解集。
     * 组合类的题目汇总：https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
     */

    //递归，把问题拆分为N选X的组合问题，从N中选择0到X，相加即为所有子集
    public List<List<Integer>> subsets(int[] nums) {
        int len = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || (len = nums.length) == 0) return result;


        for (int i = 0; i <= len; ++i) {
            Deque<Integer> path = new ArrayDeque<>();
            dsp(nums, len, i, 0, path, result);
        }

        return result;
    }

    private void dsp(int[] nums, int len, int size, int start, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == size) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len - size + path.size() + 1; ++i) {
            path.addLast(nums[i]);
            dsp(nums, len, size, i + 1, path, result);
            path.removeLast();
        }
    }


    //第二种实现也是递归
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    //第三种为迭代
    public List<List<Integer>> subsets2(int[] nums) {
        int len = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || (len = nums.length) == 0) return result;
        result.add(Collections.emptyList());// 添加一个[]
        for (int i = 0; i < len; ++i) {
            int n=result.size();
            for (int j=0;j<n;++j) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return  result;
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }
}
