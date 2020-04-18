package leetcode.array;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's. Could
 * you come up with a one-pass algorithm using only constant space?
 * 
 * @author Ikaros
 *
 */
public class N75SortColors {
	public void sortColors(int[] nums) {
		quick3Ways(nums);
	}

	private void quick3Ways(int[] nums) {
		int zero = -1;// [0...zero]==0
		int two = nums.length;// [two...n-1]==2
		for (int i = 0; i < two;)
			if (nums[i] == 1)
				i++;
			else if (nums[i] == 2)
				swap(nums, i, --two);
			else // nums[i]==0
				swap(nums, ++zero, i++);

	}

	private void insertSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			int j;
			for (j = i; j > 0 && temp < nums[j - 1]; j--)
				nums[j] = nums[j - 1];
			nums[j] = temp;
		}

	}

	private static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}
