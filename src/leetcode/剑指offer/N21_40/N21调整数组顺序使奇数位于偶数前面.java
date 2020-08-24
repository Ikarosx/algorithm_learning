package leetcode.剑指offer.N21_40;

import org.junit.Assert;
import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author Ikarosx
 * @date 2020/8/24 15:20
 */
public class N21调整数组顺序使奇数位于偶数前面 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 1}, exchange(new int[]{1, 3, 5}));
    }

    public int[] exchange(int[] nums) {
        // [0, l]表示奇数
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while ((nums[l] & 1) == 1) {
                l++;
                if (l > r) {
                    return nums;
                }
            }
            while ((nums[r] & 1) == 0) {
                r--;
                if (l > r) {
                    return nums;
                }
            }

            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
        return nums;
    }
}
