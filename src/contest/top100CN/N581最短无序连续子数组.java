package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author Ikarosx
 * @date 2020/7/23 11:57
 */
public class N581最短无序连续子数组 {
    @Test
    public void test() {
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2}));
    }
    
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int left = 0, right = -1;
        int max = nums[0], min = nums[length - 1];
        for (int i = 0; i < length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            if (nums[length - i - 1] > min) {
                left = length - i - 1;
            } else {
                min = nums[length - i - 1];
            }
        }
        return right - left + 1;
    }
    
}
