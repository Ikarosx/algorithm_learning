package leetcode.序号.n500;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：

	在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。


相关标签：
	双指针
	字符串

原题地址：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N557反转字符串中的单词III {
 	@Test
 	public void test () {
		Assertions.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
 	}

 	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		int pre = 0;
		for (int i = 0; i < chars.length; i++) {
			// 如果遇到空格
			if (chars[i] == ' ') {
				reverse(chars, pre, i - 1);
				pre = i + 1;
			}
			// 如果是最后一个
			if (i == chars.length - 1) {
				// 不是i-1了
				reverse(chars, pre, i);
			}
		}
		return new String(chars);
	}

	private void reverse(char[] chars, int i, int j) {
		for (int k = i; k <= (j + i) / 2; k++) {
			char temp = chars[k];
			chars[k] = chars[j + i - k];
			chars[j + i - k] = temp;
		}
	}
}