package leetcode.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 * @author Ikaros
 *
 */
public class N451SortCharactersByFrequency {
	HashMap<Character, Integer> freq;

	public class FrequencyComparator implements Comparator<Character> {
		@Override
		public int compare(Character o1, Character o2) {
			return freq.get(o2).compareTo(freq.get(o1));
		}
	}

	public String frequencySort(String s) {
		freq = new HashMap();

		for (int i = 0; i < s.length(); ++i) {
			increment(freq, s.charAt(i));
		}

		ArrayList<Character> keys = new ArrayList<>(freq.keySet());
		keys.sort(new FrequencyComparator());

		StringBuilder sb = new StringBuilder(s.length());
		for (Character c : keys) {
			for (int i = 0; i < freq.get(c); ++i)
				sb.append(c);
		}

		return sb.toString();
	}

	private void increment(HashMap<Character, Integer> map, Character key) {
		if (map.containsKey(key)) {
			int val = map.get(key);
			map.put(key, ++val);
		} else {
			map.put(key, 1);
		}
	}

}
