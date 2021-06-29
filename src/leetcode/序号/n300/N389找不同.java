package leetcode.序号.n300;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定两个字符串 <em>s</em> 和 <em>t</em>，它们只包含小写字母。
 * <p>
 * 字符串&nbsp;<em>t</em>&nbsp;由字符串&nbsp;<em>s</em>&nbsp;随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 <em>t</em> 中被添加的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * <p>
 * 相关标签：
 * 位运算
 * 哈希表
 * 字符串
 * 排序
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/find-the-difference/
 *
 * @author Ikarosx
 * @date 2021/6/29
 */
public class N389找不同 {

    @Test
    public void test() {
        Assertions.assertEquals('e', findTheDifference("abcd", "abcde"));
        Assertions.assertEquals('y', findTheDifference("", "y"));
        Assertions.assertEquals('a', findTheDifference("a", "aa"));
        Assertions.assertEquals('a', findTheDifference("ae", "aea"));
    }

    /**
     * 累加ASCII码
     */
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c : t.toCharArray()) {
            sum += c;
        }
		for (char c : s.toCharArray()) {
			sum -= c;
		}
		return (char) sum;
    }

	/**
	 * 异或
	 */
	public char findTheDifference3(String s, String t) {
		int sum = 0;
		for (char c : (t + s).toCharArray()) {
			sum ^= c;
		}
		return (char) sum;
	}

	/**
     * 排序，nlogn
     */
    public char findTheDifference1(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return b[i];
            }
        }
        return b[b.length - 1];
    }

    /**
     * map映射
     */
    public char findTheDifference2(String s, String t) {
        int[] sMap = new int[26];
        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            sMap[c - 'a']--;
            if (sMap[c - 'a'] < 0) {
                return c;
            }
        }
        return t.charAt(t.length() - 1);
    }
}