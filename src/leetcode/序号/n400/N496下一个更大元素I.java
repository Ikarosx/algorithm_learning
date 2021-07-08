package leetcode.序号.n400;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * 给你两个 没有重复元素 的数组&nbsp;nums1 和&nbsp;nums2&nbsp;，其中nums1&nbsp;是&nbsp;nums2&nbsp;的子集。

请你找出 nums1&nbsp;中每个元素在&nbsp;nums2&nbsp;中的下一个比其大的值。

nums1&nbsp;中数字&nbsp;x&nbsp;的下一个更大元素是指&nbsp;x&nbsp;在&nbsp;nums2&nbsp;中对应位置的右边的第一个比&nbsp;x&nbsp;大的元素。如果不存在，对应位置输出 -1 。

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。

示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
&nbsp;   对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。

提示：

	1 <= nums1.length <= nums2.length <= 1000
	0 <= nums1[i], nums2[i] <= 10<sup>4</sup>
	nums1和nums2中所有整数 互不相同
	nums1 中的所有整数同样出现在 nums2 中

进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？

相关标签：
	栈
	数组
	哈希表
	单调栈

原题地址：https://leetcode-cn.com/problems/next-greater-element-i/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/8 
 */ 
 public class N496下一个更大元素I {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i : nums2) {
			if (stack.isEmpty()) {
				// 为空入栈
				stack.push(i);
			} else {
				while (!stack.isEmpty() && stack.peek() < i) {
					// 不为空且栈顶数小于当前数，说明栈顶数的右边第一大就是当前数
					map.put(stack.pop(), i);
				}
				stack.push(i);
			}
		}
		int[] ints = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			ints[i] = map.getOrDefault(nums1[i], -1);
		}
		return ints;
	}
 } 