package leetcode.search;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author Ikaros
 *
 */
public class N242ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] c1 = new char[256];
		char[] c2 = new char[256];

		for (int i = 0; i < s.length(); i++) {
			c1[s.charAt(i)]++;
			c2[t.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		return true;
	}
}
