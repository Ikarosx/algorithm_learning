package leetcode.序号.n200;

import java.util.Arrays;

/**
 * 给定两个字符串 <em>s</em> 和 <em>t</em> ，编写一个函数来判断 <em>t</em> 是否是 <em>s</em> 的字母异位词。
 * <p>
 * 示例&nbsp;1:
 * <p>
 * 输入: <em>s</em> = "anagram", <em>t</em> = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: <em>s</em> = "rat", <em>t</em> = "car"
 * 输出: false
 * <p>
 * 说明:<br>
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:<br>
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 相关标签：
 * 排序
 * 哈希表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author Ikarosx
 * @date 2021/4/29
 */
public class N242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return new String(chars).equals(new String(chart));
    }
}