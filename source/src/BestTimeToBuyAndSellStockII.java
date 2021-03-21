public class BestTimeToBuyAndSellStockII {
    /*
     * 题 目：买卖股票的最佳时机
     * 链 接: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 描 述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *       设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     */
    public int maxProfit(int[] prices) {
        int len = 0;
        int total = 0;
        if (prices == null || (len = prices.length) == 0) return total;
        for (int i = 0; i < len; ++i) {
            if (i > 0 && prices[i] > prices[i - 1]) total += prices[i] - prices[i - 1];
        }
        return total;
    }
}
