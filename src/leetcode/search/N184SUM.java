package leetcode.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author Ikaros
 *
 */
public class N184SUM {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		int n = nums.length;
		if (n < 4) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (!(i == 0 || (i > 0 && nums[i] != nums[i - 1]))) {
				continue;
			}
			int sum1 = target - nums[i];
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (!(j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1]))) {
					continue;
				}
				int l = j + 1, r = nums.length - 1, sum = sum1 - nums[j];
				while (l < r) {
					if (nums[l] + nums[r] == sum) {
						result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while (l < r && nums[l] == nums[++l])
							;

						while (l < r && nums[r] == nums[--r])
							;

					} else if (nums[l] + nums[r] < sum) {
						l++;
					} else {
						r--;
					}
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0 };
		int target = 0;
		System.out.println(fourSum(arr, target).toString());
	}
}
