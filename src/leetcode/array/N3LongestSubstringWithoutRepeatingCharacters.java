package leetcode.array;

/**
 * Given a string, find the length of the longest substring
 * without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 * @author Ikaros
 */
public class N3LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        // [l,r]滑动窗口
        int l = 0, r = -1;
        int[] ints = new int[256];
        char[] array = s.toCharArray();
        while (l < array.length) {
            if (r + 1 < array.length && ints[array[r + 1]] == 0) {
                ints[array[++r]]++;
            } else {
                ints[array[l++]]--;
            }
            res = Math.max(res, r - l + 1);
        } return res;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abccbaadfghg"));
    }
}
