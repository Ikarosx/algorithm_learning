package contest.top100;

import org.junit.jupiter.api.Test;

/**
 * @author Ikaros
 * @date 2020/6/9 11:22
 */
public class N198HouseRobber {
    @Test
    public void test() {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
