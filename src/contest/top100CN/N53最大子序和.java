package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author Ikaros
 * @date 2020/7/3 7:47
 */
public class N53最大子序和 {
    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2}));
    }
    
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int num : nums) {
            temp += num;
            max = Math.max(max, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }
}
