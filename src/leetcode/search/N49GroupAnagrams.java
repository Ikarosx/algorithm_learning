package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 * @author Ikaros
 *
 */
public class N49GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new LinkedList<List<String>>();
		if (strs.length == 0 || strs == null) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String string = String.valueOf(charArray);
			if (!map.containsKey(string)) {
				map.put(string, new LinkedList<String>());

			}
			map.get(string).add(str);
		}

		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		String[] strs = { "tea", "and", "ace", "ad", "eat", "dans" };
		System.out.println(groupAnagrams(strs).toString());

	}
}
