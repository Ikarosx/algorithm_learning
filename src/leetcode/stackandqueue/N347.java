package leetcode.stackandqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @author Ikaros
 *
 */
public class N347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		return result;
	}

	class Pair {
		int freq;
		int value;

		public Pair(int freq, int value) {
			super();
			this.freq = freq;
			this.value = value;
		}
	}
}
