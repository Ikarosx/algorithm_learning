package leetcode.周赛.w220;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * 返回 只删除一个 子数组可获得的 最大得分 。
 *
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 *
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 * @author Ikarosx
 * @date 2020/12/20 10:46
 */
public class N5630删除子数组的最大得分 {

    public int maximumUniqueSubarray(int[] nums) {
        // 最长连续子数组
        int[] arr = new int[10001];
        int result = nums[0];
        int temp = nums[0];
        arr[nums[0]] = 1;
        // [l, r]
        int l = 0;
        int r = 0;
        while (++r < nums.length) {
            int num = nums[r];
            if (arr[num] > 0) {
                // 已经出现过
                while (nums[l] != num) {
                    temp -= nums[l];
                    arr[nums[l]]--;
                    l++;
                }
                l++;
            } else {
                // 没有出现过
                temp += nums[r];
                arr[nums[r]]++;
                result = Math.max(temp, result);
            }
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(17, maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        Assert.assertEquals(8, maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
        Assert.assertEquals(1, maximumUniqueSubarray(new int[]{1, 1, 1, 1}));
        Assert.assertEquals(1, maximumUniqueSubarray(new int[]{1}));
    }
}
