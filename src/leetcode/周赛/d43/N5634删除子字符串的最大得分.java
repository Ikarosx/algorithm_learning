package leetcode.周赛.d43;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 *
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 * 示例 2：
 *
 * 输入：s = "aabbaaxybbaabb", x = 5, y = 4
 * 输出：20
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * 1 <= x, y <= 104
 * s 只包含小写英文字母。
 *
 * @author Ikarosx
 * @date 2021/1/9 22:48
 */
public class N5634删除子字符串的最大得分 {

    int result = 0;

    @Test
    public void test() {
        Assert.assertEquals(19, maximumGain("cdbcbbaaabab", 4, 5));
        Assert.assertEquals(20, maximumGain("aabbaaxybbaabb", 5, 4));
        Assert.assertEquals(20, maximumGain("ababa", 1, 10));
    }

    public int maximumGain(String s, int x, int y) {
        int result = 0;
        // 预处理
        if (x < y) {
            // 交换xy
            int temp = x;
            x = y;
            y = temp;
            // 反转s
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a') {
                    chars[i] = 'b';
                } else if (chars[i] == 'b'){
                    chars[i] = 'a';
                }
            }
            s = new String(chars);
        }
        int i = 0;
        int n = s.length();
        while (i < n) {
            while (i < n && s.charAt(i) != 'a' && s.charAt(i) != 'b') {
                i++;
            }
            int ca = 0, cb = 0;
            while (i < n && (s.charAt(i) == 'a' || s.charAt(i) == 'b')) {
                if (s.charAt(i) == 'a') {
                    ca++;
                } else {
                    if (ca > 0) {
                        ca--;
                        result += x;
                    } else {
                        cb++;
                    }
                }
                i++;
            }

            result += Math.min(ca, cb) * y;
        }
        return result;
    }


}
