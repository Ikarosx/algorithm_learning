package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Ikaros
 * @date 2020/6/29 17:12
 */
public class N34在排序数组中查找元素的第一个和最后一个位置 {
    @Test
    public void test() {
        int[] ints = searchRange(new int[]{5, 5}, 5);
        System.out.println(Arrays.toString(ints));
    }
    
    /**
     * 官方答案
     */
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        
        int leftIdx = extremeInsertionIndex(nums, target, true);
        
        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        
        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        
        return targetRange;
    }
    
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
}
