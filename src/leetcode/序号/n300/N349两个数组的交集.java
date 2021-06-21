package leetcode.序号.n300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：

	输出结果中的每个元素一定是唯一的。
	我们可以不考虑输出结果的顺序。


相关标签：
	排序
	哈希表
	双指针
	二分查找

原题地址：https://leetcode-cn.com/problems/intersection-of-two-arrays/
  
 *  
 * @author Ikarosx 
 * @date 2021/6/21 
 */ 
 public class N349两个数组的交集 {
	/**
	 * 两个HashSet
	 */
 	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> integers = new HashSet<>();
		for (int i : nums1) {
			integers.add(i);
		}
		HashSet<Integer> integers2 = new HashSet<>();
		for (int i : nums2) {
			if (integers.contains(i)) {
				integers2.add(i);
			}
		}
		int[] ints = new int[integers2.size()];
		int i = 0;
		for (Integer integer : integers2) {
			ints[i++] = integer;
		}
		return ints;
	}
 } 