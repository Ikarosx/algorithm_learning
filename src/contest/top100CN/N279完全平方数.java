package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author Ikarosx
 * @date 2020/7/18 8:21
 */
public class N279完全平方数 {
    @Test
    public void test() {
        System.out.println(numSquares(1));
    }
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
