package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/target-sum/
 *
 * @author Ikarosx
 * @date 2020/7/21 9:54
 */
public class N494目标和 {
    
    
    @Test
    public void test() {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    
    int result = 0;
    
    
    public int findTargetSumWays(int[] nums, int S) {
        // dfs(nums, 0, S);
        // 用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
    
    private void dfs(int[] nums, int i, int s) {
        if (s == 0 && i == nums.length) {
            result++;
        }
        if (i >= nums.length) {
            return;
        }
        dfs(nums, i + 1, s - nums[i]);
        dfs(nums, i + 1, s + nums[i]);
    }
}
