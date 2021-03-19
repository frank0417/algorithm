package dp;

public class HouseRobberII {
    /*
     * 题 目：打家劫舍II
     * 链 接: https://leetcode-cn.com/problems/house-robber-ii
     * 描 述：你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     *       这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
     *       系统会自动报警 。
     *       给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     */
    //时间复杂度O(n)空间复杂度O(1)
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int [] dp = new int[4];
        for (int i = 0; i < len-1; ++i) {
            int temp=dp[1];
            dp[1] = Math.max(dp[1], dp[0] + nums[i]);
            dp[0]=temp;

            int temp2=dp[3];
            dp[3] = Math.max(dp[3], dp[2] + nums[i+1]);
            dp[2]=temp2;
        }
        return Math.max(dp[1],dp[3]);
    }
}
