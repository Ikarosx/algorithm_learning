package leetcode.search;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author Ikaros
 *
 */
public class N163SumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		int result = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[r] + nums[l] + nums[i];
				if (sum < target) {
					l++;
				} else {
					r--;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1 };
		int target = 0;
		System.out.println(threeSumClosest(nums, target));
	}
}
