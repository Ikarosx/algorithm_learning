package leetcode.序号.n300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * <p>
 * <p>
 * 相关标签：
 * 双指针
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * @author Ikarosx
 * @date 2021/6/17
 */
public class N345反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while (l < r) {
            while (l < r) {
                if (set.contains(chars[l])) {
                    break;
                }
                l++;
            }
            while (l < r) {
                if (set.contains(chars[r])) {
                    break;
                }
                r--;
            }
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }

}