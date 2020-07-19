package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author Ikarosx
 * @date 2020/7/18 17:31
 */
public class N300最长上升子序列 {
    @Test
    public void test() {
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
    
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // dp[i]表示以nums[i]结尾的最长上升子序列的最大长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int j;
            int maxj = 0;
            for (j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    maxj = Math.max(maxj, dp[j]);
                }
            }
            dp[i] = maxj + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
