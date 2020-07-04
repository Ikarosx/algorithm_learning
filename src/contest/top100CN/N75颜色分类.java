package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author Ikaros
 * @date 2020/7/4 7:38
 */
public class N75颜色分类 {
    @Test
    public void test() {
        int[] ints = {1, 1, 0};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }
    
    
    public void sortColors(int[] nums) {
        // [0, l]表示0
        int l = -1;
        // [r, num.length - 1]表示2
        int r = nums.length;
        // [l, r]表示1
        int i = 0;
        while (i < r) {
            if (nums[i] == 0) {
                swap(nums, i++, ++l);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, --r);
            }
        }
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
