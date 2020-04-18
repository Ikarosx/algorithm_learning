package leetcode.array;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5 Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4 Note: You may assume k is
 * always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Ikaros
 *
 */
public class N215KthLargestElementinanArray {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 5, 6, 4 };
		findKthLargest(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

	public static int findKthLargest(int[] nums, int k) {
		__quickSort(nums, 0, nums.length - 1);
		return nums[nums.length - k];
	}

	private static void __quickSort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}

		// __partition

		swap(arr, l, l + (int) (Math.random() * (r - l + 1)));
		int v = arr[l];
		int lt = l;// arr[l+1...lt]<v
		int gt = r + 1;// arr[gt...r]>v
		int i = l + 1;// arr[lt+1...i]==v
		while (i < gt) {
			if (arr[i] < v) {
				swap(arr, i, lt + 1);
				lt++;
				i++;
			} else if (arr[i] > v) {
				swap(arr, i, gt - 1);
				gt--;
			} else {
				i++;
			}
		}
		swap(arr, l, lt);
		__quickSort(arr, l, lt - 1);
		__quickSort(arr, gt, r);
	}

	private static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}
