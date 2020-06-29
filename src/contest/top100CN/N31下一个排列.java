package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author Ikaros
 * @date 2020/6/28 19:10
 */
public class N31下一个排列 {
    @Test
    public void test() {
        int[] nums = {1, 5, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                i--;
                int j = nums.length - 1;
                for (; j >= i && nums[j] <= nums[i]; j--) {
                }
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
