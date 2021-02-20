public class RemoveDuplicates {

    /*
     * 题 目：删除排序数组中的重复项
     * 链 接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * 描 述：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[k] == nums[i]) continue;
            if (k < i) nums[++k] = nums[i];
        }
        return k + 1;
    }
}
