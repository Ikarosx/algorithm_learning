package leetcode.序号.n500;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔&nbsp;2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * 提示：
 *
 * <ol>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * </ol>
 * <p>
 * 相关标签：
 * 双指针
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @author Ikarosx
 * @date 2021/7/12
 */
public class N541反转字符串II {

	@Test
	public void test () {
		Assertions.assertEquals("bacdfeg", reverseStr("abcdefg", 2));
	}

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            // 剩余字符
            int d = chars.length - i;

            if (d < k) {
                reverse(chars, i, chars.length - 1);
            } else {
                reverse(chars, i, i + k - 1);
            }
        }
        return new String(chars);
    }

    // 交换[i, j]
	private void reverse(char[] chars, int i, int j) {
		for (int k = i; k <= (i+j) / 2; k++) {
			char temp = chars[k];
			chars[k] = chars[j + i - k];
			chars[j + i - k] = temp;
		}
	}
}