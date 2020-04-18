package leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author Ikaros
 *
 */
public class N1TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int[] res = new int[2];
		for (int i : nums) {
			if (map.containsKey(target - i)) {
				res[0] = count;
				res[1] = map.get(target - i);
				return res;
			}
			map.put(i, count++);
		}
		return res;
	}
}
