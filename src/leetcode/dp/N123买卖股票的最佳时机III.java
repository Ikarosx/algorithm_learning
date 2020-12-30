package leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/30 10:30
 */
public class N123买卖股票的最佳时机III {

    @Test
    public void test() {
        Assert.assertEquals(6, maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        Assert.assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 已经买卖了
        int a = 0;
        int b = -prices[0];
        int c = 0;
        int d = -prices[0];
        int e = 0;

        for (int i = 1; i < n; i++) {
            // 第一次买入：
            int bb = Math.max(b, a - prices[i]);
            // 第一次卖出
            int cc = Math.max(c, b + prices[i]);
            // 第二次买入：
            int dd = Math.max(d, c - prices[i]);
            // 第二次卖出
            int ee = Math.max(e, d + prices[i]);
            b = bb;
            c = cc;
            d = dd;
            e = ee;
        }
        return Math.max(Math.max(Math.max(b, c), Math.max(d, e)), a);
    }

    /**
     * 二维DP
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        // 已经买卖了
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; i++) {
            // 第一次买入：
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第一次卖出
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 第二次买入：
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 第二次卖出
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return Math.max(
            Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), Math.max(dp[n - 1][2], dp[n - 1][3])),
            dp[n - 1][4]);
    }

    /**
     * 三维DP
     */
    public int maxProfit1(int[] prices) {
        // 0表示未持有，昨天也未持有
        // 1表示持有，昨天持有，今天买
        // dp[i]表示卖出了i次的时候
        int length = prices.length;
        int[][][] dp = new int[length][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 没卖出的时候
            // 昨天也未持有
            dp[i][0][0] = dp[i - 1][0][0];
            // 昨天持有，今天买
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);

            // 卖出1次的时候
            // 卖出一次的时候未持有，卖出一次时未持有，卖出0次持有，今天卖出
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            // 卖出一次的时候持有，卖出一次时持有，卖出1次没持有，今天买入
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);

            // 卖出2次的时候
            // 卖出2次的时候未持有，卖出2次时未持有，卖出1次持有，今天卖出
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        int n = length - 1;
        return Math.max(dp[n][0][0], Math.max(dp[n][1][0], dp[n][2][0]));
    }
}
