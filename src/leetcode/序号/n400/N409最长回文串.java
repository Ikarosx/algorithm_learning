package leetcode.序号.n400;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如&nbsp;"Aa"&nbsp;不能当做一个回文字符串。

注意:<br>
假设字符串的长度不会超过 1010。

示例 1: 

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。


相关标签：
	贪心
	哈希表
	字符串

原题地址：https://leetcode-cn.com/problems/longest-palindrome/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/2 
 */ 
 public class N409最长回文串 {

 	@Test
 	public void test () {
		Assertions.assertEquals(7, longestPalindrome("abccccdd"));
 	}

	public int longestPalindrome(String s) {
		int[] count = new int[128];
		int length = s.length();
		for (int i = 0; i < length; ++i) {
			char c = s.charAt(i);
			count[c]++;
		}

		int ans = 0;
		for (int v: count) {
			ans += v / 2 * 2;
			// 第一次出现奇数的时候
			if (v % 2 == 1 && ans % 2 == 0) {
				ans++;
			}
		}
		return ans;
	}


 } 