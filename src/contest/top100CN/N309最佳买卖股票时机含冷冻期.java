package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author Ikarosx
 * @date 2020/7/19 8:04
 */
public class N309最佳买卖股票时机含冷冻期 {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
    
    /**
     * 1. 状态定义
     * 2. 状态转移方程
     * 3. 初始化
     * 4. 思考输出
     * 5. 状态压缩
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[i][j]表示第i天结束之后能获得的最大收益
        // j分别为012表示持股，不持股处于冷冻期，不持股不处于冷冻期
        // 处于冷冻期指的是第i天结束之后的状态，即第i+1天无法买入股票
        //
        //
        // 不持股不处于冷冻期两个状态转换：不持股不处于冷冻期、不持股处于冷冻期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        // 状态转移方程
        int length = dp.length;
        for (int i = 1; i < length; i++) {
            // 持股由两个状态转换：不持股不处于冷冻期，持股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 不持股处于冷冻期由一个状态转换：昨天持股今天卖出
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 不持股不处于冷冻期由两个状态转换：昨天不持股，今天也不持股，包含冷冻和非冷冻
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }
}
