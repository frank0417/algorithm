package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Foursum {
    /*
     * 题 目：四数之和
     * 链 接: https://leetcode-cn.com/classic/problems/4sum/description/
     * 描 述：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = 0;
        if (nums == null || (len = nums.length) <4) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if ((nums[0] + nums[1] + nums[2] + nums[3]) > target || (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4]) < target) {
            return Collections.emptyList();
        }
        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        Foursum foursum=new Foursum();
        foursum.fourSum(new int[]{2,1,0,-1},2);
    }
}
