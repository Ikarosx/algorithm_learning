package leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/30 9:52
 */
public class N122买卖股票的最佳时机II {

    @Test
    public void test() {
        Assert.assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    // DP
    public int maxProfit(int[] prices) {
        // 当天只会有持有和没有持有
        // 0为持有，1为没有持有
        // 持有可以由持有，未持有 + 今天买股票的钱
        // 交易完没有持有，表示上一次持有今天卖掉，或者上次也没有
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        }
        return dp[length - 1][1];
    }

    // 贪心
    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }

    // 模拟
    public int maxProfit1(int[] prices) {
        // 尽可能多次
        int result = 0;
        int n = 0;
        while (n < prices.length) {
            // 找到最小值
            int min = prices[n];
            while (n < prices.length && prices[n] <= min) {
                min = prices[n];
                n++;
            }
            // 到底了
            if (n == prices.length) {
                break;
            }
            // 找到最大值
            int max = min;
            while (n < prices.length && prices[n] >= max) {
                max = prices[n];
                n++;
            }
            result += max - min;
        }
        return result;
    }
}
