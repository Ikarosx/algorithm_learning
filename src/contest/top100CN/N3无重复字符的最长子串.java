package contest.top100CN;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Ikaros
 * @date 2020/06/24 00:24
 */
public class N3无重复字符的最长子串 {
    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("   "));
    }
    
    public int lengthOfLongestSubstring(String s) {
        // 优化：chars存的不是数量，而是index
        int[] chars = new int[256];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }
        int max = 0;
        // [start,end)存
        int start = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (chars[s.charAt(i)] >= start) {
                start = chars[s.charAt(i)] + 1;
            }
            chars[s.charAt(i)] = i;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
