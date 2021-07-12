package leetcode.序号.n500;

import sun.misc.ObjectInputFilter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

示例 1:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。

示例 2:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。

提示:

<ol>
	两个列表的长度范围都在&nbsp;[1, 1000]内。
	两个列表中的字符串的长度将在[1，30]的范围内。
	下标从0开始，到列表的长度减1。
	两个列表都没有重复的元素。
</ol>

相关标签：
	数组
	哈希表
	字符串

原题地址：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N599两个列表的最小索引总和 { 
 	public String[] findRestaurant(String[] list1, String[] list2) {
 		// 哈希
		HashMap<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			m1.put(list1[i], i);
		}
		ArrayList<String> result = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			String s = list2[i];
			if (m1.containsKey(s)) {
				int sum = m1.get(s) + i;
				if (sum < min) {
					result.clear();
					result.add(s);
				} else if (sum == min) {
					result.add(s);
				}
				min = Math.min(min, sum);
			}
		}
		return result.toArray(new String[]{});
	}
 } 