package leetcode.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
 * @author Ikaros
 *
 */
public class N350IntersectionofTwoArrays2 {
	public static int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i : nums1) {
			if (map1.containsKey(i)) {
				map1.put(i, map1.get(i) + 1);
			} else {
				map1.put(i, 1);
			}
		}
		for (int i : nums2) {
			if (map1.containsKey(i) && map1.get(i) > 0) {
				list.add(i);
				map1.put(i, map1.get(i) - 1);
			}
		}
		int[] newArr = new int[list.size()];
		int count = 0;
		for (int i : list) {
			newArr[count++] = i;
		}
		return newArr;

	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 1, 2, 3 };
		int[] nums2 = { 1, 1, 2, 3 };
		int[] nums3 = intersection(nums1, nums2);
		for (int i : nums3) {
			System.out.println(i);
		}
	}
}
