package leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 * @author Ikaros
 *
 */
public class N205IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			Character c1 = s.charAt(i);
			Character c2 = t.charAt(i);
			if (map.containsKey(c1)) {
				if (map.get(c1) != c2) {
					return false;
				}
			} else {
				if (map.containsValue(c2)) {
					return false;
				}
				map.put(c1, c2);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		isIsomorphic("egg", "add");

	}
}
