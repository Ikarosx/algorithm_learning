package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class N127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Queue<StringPair> queue = new LinkedList<StringPair>();
		queue.add(new StringPair(beginWord, 1));
		boolean[] visited = new boolean[wordList.size() + 1];
		while (!queue.isEmpty()) {
			StringPair remove = queue.remove();
			String string = remove.string;
			int step = remove.step;
			for (int i = wordList.size() - 1; i >= 0; i--) {
				if (!visited[i]) {
					String word = wordList.get(i);
					if (similar(string, word)) {
						if (word.equals(endWord)) {
							return step + 1;
						}
						queue.add(new StringPair(word, step + 1));
						visited[i] = true;
					}
				}
			}
		}
		return 0;
	}

	private boolean similar(String word1, String word2) {
		int diff = 0;
		for (int i = 0; i < word1.length(); i++)
			if (word1.charAt(i) != word2.charAt(i)) {
				diff++;
				if (diff > 1)
					return false;
			}
		return true;
	}

	class StringPair {
		String string;
		int step;

		public StringPair(String string, int step) {
			super();
			this.string = string;
			this.step = step;
		}
	}
}
