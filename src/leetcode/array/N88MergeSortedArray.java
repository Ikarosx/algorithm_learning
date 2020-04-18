package leetcode.array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2. Example:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * @author Ikaros
 *
 */
public class N88MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = n + m - 1; i >= n; i--)
			nums1[i] = nums1[i - n];

		int i = n; // pointer for nums1 [n, n+m)
		int j = 0; // pointer for nums2 [0, n)
		int k = 0; // pointer merged nums1 [0, n+m)
		while (k < n + m) {
			if (i >= n + m)
				nums1[k++] = nums2[j++];
			else if (j >= n)
				nums1[k++] = nums1[i++];
			else if (nums1[i] < nums2[j])
				nums1[k++] = nums1[i++];
			else
				nums1[k++] = nums2[j++];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 5, 6, 0, 0, 0 };
		int[] nums2 = { 1, 2, 3 };
		merge(nums1, 3, nums2, nums2.length);
		System.out.println(Arrays.toString(nums1));
	}
}
