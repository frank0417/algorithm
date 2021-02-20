public class MoveZeroes {

    /*
     * 题 目：移动零
     * 链 接：https://leetcode-cn.com/problems/move-zeroes/
     * 描 述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        int length = 0;
        if (nums == null || (length = nums.length) == 0) return;
        int j = 0;
        for (int i = 0; i < length; ++i) {
            if (nums[i] != 0) {
                if (j < i) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
