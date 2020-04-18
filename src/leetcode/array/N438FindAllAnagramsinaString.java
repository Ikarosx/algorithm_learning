package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @author Ikaros
 *
 */
public class N438FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
		// 滑动窗口
		int l = 0;
		int r = -1;
		int count = 0;
		char[] chars = s.toCharArray();
		int[] ints = new int[256];
		for (char c : p.toCharArray()) {
			ints[c]++;
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (l < s.length()) {
			if (r + 1 < s.length() && ints[chars[r + 1]] != 0) {
				count++;
				ints[chars[++r]]--;
				if (count == p.length()) {
					list.add(l);
					count--;
					ints[chars[l++]]++;
				}
			} else {
				count--;
				ints[chars[l++]]++;
			}
		}
		return list;
	}
	
	@Test
	public void test() {
		System.out.println(findAnagrams("a", "ab"));
	}
}
