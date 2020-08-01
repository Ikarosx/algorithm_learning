package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * https://leetcode-cn.com/problems/edit-distance/solution/shi-pin-jiang-jie-bian-ji-ju-chi-dong-tai-gui-hua-/
 *
 * @author Ikarosx
 * @date 2020/8/1 8:03
 */
public class N72编辑距离 {

    @Test
    public void test() {
        System.out.println(minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int w1l = word1.length();
        int w2l = word2.length();
        int[][] dp = new int[w1l + 1][w2l + 1];
        int dl = dp.length;
        for (int i = 0; i < dl; i++) {
            dp[i][0] = i;
        }
        int dp0l = dp[0].length;
        for (int i = 0; i < dp0l; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1l; i++) {
            for (int j = 1; j <= w2l; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[w1l][w2l];
    }
}
