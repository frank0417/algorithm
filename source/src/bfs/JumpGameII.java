package bfs;

public class JumpGameII {
    /*
     * 题 目：跳跃游戏 II
     * 链 接: https://leetcode-cn.com/problems/jump-game-ii/
     * 描 述：给定一个非负整数数组，你最初位于数组的第一个位置。
     *       数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *       你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     */
    //时间复杂度O(m*n)空间复杂度O(m*n)
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
