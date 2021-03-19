package dp;

import java.util.Arrays;

public class CoinChange {
    /*
     * 题 目：零钱兑换
     * 链 接: https://leetcode-cn.com/problems/coin-change/
     * 描 述：给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    //时间复杂度O(conins.length*amount)空间复杂度O(amount+1)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i) {
            for (int j : coins) if (i >= j) dp[i] = Math.min(dp[i], dp[i - j] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //BFS
    public int coinChangeII(int[] coins, int amount) {
        return 0;
    }
}
