package leetcode.序号.n200;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n]&nbsp;中&nbsp;n&nbsp;个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

进阶：

	你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

示例 1：

输入：nums = [3,0,1]
输出：2
<b>解释：</b>n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。

示例 2：

输入：nums = [0,1]
输出：2
<b>解释：</b>n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。

示例 3：

输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
<b>解释：</b>n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。

示例 4：

输入：nums = [0]
输出：1
<b>解释：</b>n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。

提示：

	n == nums.length
	1 <= n <= 10<sup>4</sup>
	0 <= nums[i] <= n
	nums 中的所有数字都 独一无二


相关标签：
	位运算
	数组
	数学

原题地址：https://leetcode-cn.com/problems/missing-number/
  
 *  
 * @author Ikarosx 
 * @date 2021/5/8 
 */ 
 public class N268丢失的数字 {
	/**
	 * 异或 100%
	 */
	public int missingNumber(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		return missing;
	}

	/**
	 * math
	 * 3ms 30.58%
	 * 38.7mb 91.23%
	 */
 	public int missingNumberMath(int[] nums) {
 		// 1 .. n
		// (1 + n) * n / 2
		int n = nums.length;
		int expect = (1 + n) * n / 2;
		int sum = Arrays.stream(nums).sum();
		return expect - sum;
	}
 } 