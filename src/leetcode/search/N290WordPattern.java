package leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the
 * same pattern.
 * <p>
 * Here follow means a full match, such that there is a
 * bijection between a letter in pattern and a non-empty
 * word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single
 * space.
 *
 * @author Ikaros
 */
public class N290WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        if (split.length == 1) {
            return true;
        }
        // 逆向将传进来的字符串转成字母
        String result = "";
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (map.get(s) == null) {
                if (map.containsValue(pattern.charAt(i))) {
                    return false;
                }
                map.put(s, pattern.charAt(i));
            }
            result += map.get(s);
        }
        return result.equals(pattern);
    }
    
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog d c dog"));
    }
}
