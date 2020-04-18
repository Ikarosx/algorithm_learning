package leetcode.array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 * @author Ikaros
 *
 */
public class N209MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		// [0,r]滑动窗口
		int l = 0, r = -1;
		int res = nums.length + 1;
		while (l < nums.length) {
			if (r + 1 < nums.length && sum < s) {
				sum += nums[++r];
			} else {
				sum -= nums[l++];
			}
			if (sum >= s) {
				res = Math.min(res, r - l + 1);
			}

		}
		if (res == nums.length + 1)
			return 0;

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
		int minSubArrayLen = minSubArrayLen(213, nums);
		System.out.println(minSubArrayLen);
	}
}
