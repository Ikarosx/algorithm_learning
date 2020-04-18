package leetcode.array;

import java.util.Arrays;

/**
 * NO283. Move Zeroes Given an array nums, write a function to move all 0's to
 * the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author Ikaros
 *
 */
public class N283MoveZeros {
	// 改变了相对顺序
	public void moveZeroes1(int[] nums) {
		// i:当前位置的下标
		// j:若当前位置存储为0，则应该将其放置在j，j为倒数n个数
		int i, j = nums.length - 1;
		for (i = 0; i < j; i++) {
			// 假如当前位置存储的数为0，将下标i，j的值交换，j--
			if (nums[i] == 0) {
				swap(nums, i, j);
				j--;
			}
		}
	}

	// 不改变相对顺序
	public static void moveZeroes2(int[] nums) {
		// i:当前位置的下标
		// count:统计多少个数不为0
		int i, count = 0;
		for (i = 0; i < nums.length; i++) {
			// 假如当前位置存储的数不为0，交换下标为count与i的值，count++
			// 循环执行完之后[0...count-1]前闭后闭的值应该为相对顺序不改变的不为0的值
			if (nums[i] != 0) {
				nums[count++] = nums[i];
			}

		}
		for (int j = count; j < nums.length; j++) {
			// 交换完所有不为0的值在前面之后，将[count...nums.length-1]前闭后闭的值设为0
			nums[j] = 0;
		}
	}

	// 不改变相对顺序,改进
	public static void moveZeroes3(int[] nums) {
		// i:当前位置的下标
		// count:统计多少个数不为0
		int i, count = 0;
		for (i = 0; i < nums.length; i++) {
			// 假如当前位置存储的数不为0，交换下标为count与i的值，count++
			// 循环执行完之后[0...count-1]前闭后闭的值应该为相对顺序不改变的不为0的值
			if (nums[i] != 0) {
				swap(nums, i, count++);
			}
			/*
			 * 假如数组每一个数不为0，则每一个非0元素都要与自己交换
			 * 
			 * 通过在异或里面加判断解决（一石二鸟？
			 */

		}

	}

	// 陷阱：异或自己等于0
	private static void swap(int[] nums, int i, int j) {
		if (i == j)
			return;
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 12 };
		moveZeroes2(arr);
		System.out.println(Arrays.toString(arr));
	}
}
