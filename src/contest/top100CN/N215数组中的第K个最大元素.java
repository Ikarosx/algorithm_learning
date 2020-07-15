package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author Ikarosx
 * @date 2020/7/14 20:16
 */
public class N215数组中的第K个最大元素 {
    
    @Test
    public void test() {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
    
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int target = nums.length - k;
        while (true) {
            int mid = partition(nums, l, r);
            if (mid == target) {
                break;
            } else if (mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[target];
    }
    
    private int partition(int[] nums, int l, int r) {
        int index = (int) (Math.random() * (r - l + 1)) + l;
        swap(nums, l, index);
        int temp = nums[l];
        // [l + 1, lt] < temp
        // [lt + 1, i - 1] == temp
        // [gt, r] > temp
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (nums[i] == temp) {
                i++;
            } else if (nums[i] < temp) {
                swap(nums, i++, ++lt);
            } else {
                swap(nums, i, --gt);
            }
        }
        swap(nums, l, lt);
        return lt;
    }
    
    private void swap(int[] nums, int l, int index) {
        int temp = nums[l];
        nums[l] = nums[index];
        nums[index] = temp;
    }
}
