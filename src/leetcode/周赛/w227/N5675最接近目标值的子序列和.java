package leetcode.周赛.w227;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个目标值 goal 。
 * <p>
 * 你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal 。也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum - goal) 。
 * <p>
 * 返回 abs(sum - goal) 可能的 最小值 。
 * <p>
 * 注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,-7,3,5], goal = 6
 * 输出：0
 * 解释：选择整个数组作为选出的子序列，元素和为 6 。
 * 子序列和与目标值相等，所以绝对差为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [7,-9,15,-2], goal = -5
 * 输出：1
 * 解释：选出子序列 [7,-9,-2] ，元素和为 -4 。
 * 绝对差为 abs(-4 - (-5)) = abs(1) = 1 ，是可能的最小值。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3], goal = -7
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 40
 * -107 <= nums[i] <= 107
 * -109 <= goal <= 109
 *
 * @author Ikarosx
 * @date 2021/2/7 11:12
 */
public class N5675最接近目标值的子序列和 {


    @Test

    public void test() {
        Assert.assertEquals(0, minAbsDifference(new int[]{5, -7, 3, 5}, 6));
        Assert.assertEquals(1, minAbsDifference(new int[]{7, -9, 15, -2}, -5));
        Assert.assertEquals(7, minAbsDifference(new int[]{1, 2, 3}, -7));
        Assert.assertEquals(7, minAbsDifference(new int[]{-7074297, 3076735, -5846354, 5008659, -126683, 7039557, 6708811, 3189666, -6102417, 6078975, -6448946, -4995910, 2964239, -3248847, -4392269, 7473223, -1356059, 3978911, 8009187, -316441, 6524770, 8280309, -2798383, 1310839, 6306594, -6548611, -9712711, 1639314}, 493409180));
    }

    public int minAbsDifference(int[] nums, int goal) {
        // 分左右，然后双指针
        nums = Arrays.stream(nums).boxed().filter(x -> x != 0).mapToInt(i -> i).toArray();
        int[] arr1 = new int[1 << (nums.length >> 1)];
        int[] arr2 = new int[1 << (nums.length - (nums.length >> 1))];
        int lowBit;
        for (int i = 1, len1 = arr1.length; i < len1; ++i) {
            lowBit = Integer.lowestOneBit(i);
            arr1[i] = arr1[i - lowBit] + nums[Integer.numberOfTrailingZeros(lowBit)];
        }
        for (int i = 1, len2 = arr2.length; i < len2; ++i) {
            lowBit = Integer.lowestOneBit(i);
            arr2[i] = arr2[i - lowBit] + nums[Integer.numberOfTrailingZeros(lowBit) + nums.length / 2];
        }
        Arrays.sort(arr1);
        int ans = Math.abs(goal);
        int left, right, mid;
        for (int x : arr2) {
            int curGoal = goal - x;
            left = 0;
            right = arr1.length;
            while (left < right) {
                mid = (left + right) >>> 1;
                if (arr1[mid] < curGoal) {
                    left = ++mid;
                } else {
                    right = mid;
                }
            }
            if (left != arr1.length) {
                ans = Math.min(ans, x + arr1[left] - goal);
            }
            if (left != 0) {
                --left;
                ans = Math.min(ans, goal - x - arr1[left]);
            }
        }
        return ans;
    }
}
