package dp;

public class HouseRobber {
    /*
     * 题 目：打家劫舍
     * 链 接: https://leetcode-cn.com/problems/house-robber/
     * 描 述：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     *       如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *       给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    //时间复杂度O(n)空间复杂度O(n)
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int dp[] = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    //时间复杂度O(n)空间复杂度O(1)
    public int robII(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int [] dp = new int[2];
        for (int i = 0; i < len; ++i) {
            int temp=dp[1];
            dp[1] = Math.max(dp[1], dp[0] + nums[i]);
            dp[0]=temp;
        }
        return dp[1];
    }
}
