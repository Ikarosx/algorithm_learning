package leetcode.序号.n300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

说明：

	输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
	我们可以不考虑输出结果的顺序。

进阶：

	如果给定的数组已经排好序呢？你将如何优化你的算法？
	如果&nbsp;<em>nums1&nbsp;</em>的大小比&nbsp;<em>nums2&nbsp;</em>小很多，哪种方法更优？
	如果&nbsp;<em>nums2&nbsp;</em>的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？


相关标签：
	排序
	哈希表
	双指针
	二分查找

原题地址：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
  
 *  
 * @author Ikarosx 
 * @date 2021/6/21 
 */ 
 public class N350两个数组的交集II {
	/**
	 * 两个hashmap
	 */
 	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int i : nums1) {
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}
		for (int i : nums2) {
			map2.put(i, map2.getOrDefault(i, 0) + 1);
		}
		ArrayList<Integer> integers = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			if (!map2.containsKey(entry.getKey())) {
				continue;
			}
			int c = Math.min(entry.getValue(), map2.get(entry.getKey()));
			for (int i = 0; i < c; i++) {
				integers.add(entry.getKey());
			}
		}
		int[] ints = new int[integers.size()];
		for (int i = 0; i < integers.size(); i++) {
			ints[i] = integers.get(i);
		}
		return ints;
	}

	/**
	 * 优化1：一个HashMap，且map只记录小的那个值，可以优化速度
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersectV1(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return intersectV1(nums2, nums1);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums1) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		int[] intersection = new int[nums1.length];
		int index = 0;
		for (int num : nums2) {
			int count = map.getOrDefault(num, 0);
			if (count > 0) {
				intersection[index++] = num;
				count--;
				if (count > 0) {
					map.put(num, count);
				} else {
					map.remove(num);
				}
			}
		}
		return Arrays.copyOfRange(intersection, 0, index);
	}

	/**
	 * 排序加双指针
	 */
	public int[] intersectV2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int length1 = nums1.length, length2 = nums2.length;
		int[] intersection = new int[Math.min(length1, length2)];
		int index1 = 0, index2 = 0, index = 0;
		while (index1 < length1 && index2 < length2) {
			if (nums1[index1] < nums2[index2]) {
				index1++;
			} else if (nums1[index1] > nums2[index2]) {
				index2++;
			} else {
				intersection[index] = nums1[index1];
				index1++;
				index2++;
				index++;
			}
		}
		return Arrays.copyOfRange(intersection, 0, index);
	}

 }