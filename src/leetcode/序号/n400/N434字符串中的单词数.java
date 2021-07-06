package leetcode.序号.n400;

import org.junit.Test;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * <p>
 * 相关标签：
 * 字符串
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 *
 * @author Ikarosx
 * @date 2021/7/6
 */
public class N434字符串中的单词数 {

    @Test
    public void test() {
        System.out.println(countSegments("  , , , ,        a, eaefa "));
    }

    public int countSegments(String s) {
        int result = 0;
        int old = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result += old;
                old = 0;
                continue;
            }
            old = 1;
        }
        result += old;
        return result;
    }
}