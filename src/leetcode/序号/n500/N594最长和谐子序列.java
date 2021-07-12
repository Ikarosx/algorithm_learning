package leetcode.序号.n500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。

现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。

数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。

示例 1：

输入：nums = [1,3,2,2,5,2,3,7]
输出：5
解释：最长的和谐子序列是 [3,2,2,2,3]

示例 2：

输入：nums = [1,2,3,4]
输出：2

示例 3：

输入：nums = [1,1,1,1]
输出：0

提示：

	1 <= nums.length <= 2 * 10<sup>4</sup>
	-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>


相关标签：
	数组
	哈希表
	排序

原题地址：https://leetcode-cn.com/problems/longest-harmonious-subsequence/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N594最长和谐子序列 { 
 	public int findLHS(int[] nums) {
 		// map记录所有数出现的次数
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer plus = map.get(key + 1);
			if (plus != null) {
				max = Math.max(plus + entry.getValue(), max);
			}
		}
		return max;
	}
 } 