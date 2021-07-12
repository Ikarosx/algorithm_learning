package leetcode.序号.n500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出&nbsp;N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。

(注：分数越高的选手，排名越靠前。)

示例 1:

输入: [5, 4, 3, 2, 1]
输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。

提示:

<ol>
	N 是一个正整数并且不会超过&nbsp;10000。
	所有运动员的成绩都不相同。
</ol>

相关标签：
	数组
	排序
	堆（优先队列）

原题地址：https://leetcode-cn.com/problems/relative-ranks/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N506相对名次 { 
 	public String[] findRelativeRanks(int[] score) {
 		// 排序哈希
		int[] ints = Arrays.copyOf(score, score.length);
		Arrays.sort(score);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = score.length - 1; i >= 0; i--) {
			map.put(score[i], score.length - i);
		}
		String[] result = new String[score.length];
		for (int i = 0; i < score.length; i++) {
			result[i] = transMap(map.get(ints[i]));
		}
		return result;
	}

	private String transMap(Integer integer) {

		if (integer == 1) {
			return "Gold Medal";
		}
		if (integer == 2) {
			return "Silver Medal";
		}
		if (integer == 3) {
			return "Bronze Medal";
		}
		return integer.toString();
	}
}