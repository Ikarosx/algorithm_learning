package leetcode.序号.n500;

/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：

<ol>
	'A' : Absent，缺勤
	'L' : Late，迟到
	'P' : Present，到场
</ol>

如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。

你需要根据这个学生的出勤记录判断他是否会被奖赏。

示例 1:

输入: "PPALLP"
输出: True

示例 2:

输入: "PPALLL"
输出: False


相关标签：
	字符串

原题地址：https://leetcode-cn.com/problems/student-attendance-record-i/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N551学生出勤记录I { 
 	public boolean checkRecord(String s) {
 		int aCount = 0;
 		int lSequence = 0;
		for (char c : s.toCharArray()) {
			// 处理迟到
			if (c == 'L') {
				lSequence++;
			} else {
				lSequence = 0;
			}
			// 处理缺勤
			if (c == 'A') {
				aCount++;
			}
			// 校验
			if (aCount > 1 || lSequence > 3) {
				return false;
			}
		}
		return true;
	}
 } 