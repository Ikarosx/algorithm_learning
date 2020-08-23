package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/23 9:23
 */
public class N19正则表达式匹配 {

    @Test
    public void test() {
        assert !isMatch("aa", "a");
        assert isMatch("aa", "a*");
    }

    public boolean isMatch(String s, String p) {
        // dp
        // result[i][j]表示s中前i个字符能否匹配p中前i个字符
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    result[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1)
                            || p.charAt(j - 1) == '.')) {
                            result[i][j] = result[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            result[i][j] |= result[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2)
                            || p.charAt(j - 2) == '.')) {
                            result[i][j] |= result[i - 1][j];
                        }
                    }
                }
            }
        }
        return result[s.length()][p.length()];
    }
}
