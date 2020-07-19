package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author Ikarosx
 * @date 2020/7/19 8:50
 */
public class N322零钱兑换 {
    @Test
    public void test() {
        System.out.println(coinChange(new int[]{456, 117, 5, 145}, 1459));
    }
    
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
