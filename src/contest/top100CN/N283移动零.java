package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author Ikarosx
 * @date 2020/7/18 8:53
 */
public class N283移动零 {
    @Test
    public void test() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
    
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        // [0, temp]表示非零
        int temp = -1;
        // 每次判断，如果非零，将++temp赋予该值
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[++temp] = nums[i];
            }
        }
        // 最后从[temp + 1, length]为0
        Arrays.fill(nums, temp + 1, length, 0);
    }
}
