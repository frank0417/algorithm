package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    /*
     * 题 目：三数之和
     * 链 接：https://leetcode-cn.com/classic/problems/3sum/description/
     * 描 述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = 0;
        if (nums == null || (length = nums.length) < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < length - 2; ++k) {
            int i = k + 1, j = length - 1;
            if(nums[k]>0)break;
            if(k>0 && nums[k]==nums[k-1])continue;
            while (i<j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {
                    lists.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return lists;
    }
}
