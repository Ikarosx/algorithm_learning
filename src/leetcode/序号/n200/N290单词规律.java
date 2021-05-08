package leetcode.序号.n200;

import java.util.HashMap;

/**
 * 给定一种规律 pattern&nbsp;和一个字符串&nbsp;str&nbsp;，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的&nbsp;遵循&nbsp;指完全匹配，例如，&nbsp;pattern&nbsp;里的每个字母和字符串&nbsp;str&nbsp;中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例&nbsp;4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 说明:<br>
 * 你可以假设&nbsp;pattern&nbsp;只包含小写字母，&nbsp;str&nbsp;包含了由单个空格分隔的小写字母。&nbsp; &nbsp;&nbsp;
 * <p>
 * 相关标签：
 * 哈希表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/word-pattern/
 *
 * @author Ikarosx
 * @date 2021/5/8
 */
public class N290单词规律 {
    /**
     * 哈希表
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> nmap = new HashMap<>();
        char[] patterns = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (patterns.length != strings.length) {
            return false;
        }
        for (int i = 0; i < patterns.length; i++) {
            char c = patterns[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strings[i])) {
                    return false;
                }
                if (c != (nmap.get(strings[i]))) {
                    return false;
                }
            } else {
                map.put(c, strings[i]);
                if (nmap.containsKey(strings[i])) {
                    return false;
                }
                nmap.put(strings[i], c);
            }
        }
        return true;
    }
}