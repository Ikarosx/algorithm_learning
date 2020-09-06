package leetcode.剑指offer.N41_60;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/6 9:48
 */
public class N50第一个只出现一次的字符 {

    @Test
    public void test() {
        Assert.assertEquals('b', firstUniqChar("abaccdeff"));
        Assert.assertNotEquals('c', firstUniqChar("abaccdeff"));
    }

    public char firstUniqCharByHash(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc) {
            if (dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        int result = 0;
        char[] chars = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c]++;
            while (result < s.length() && chars[s.charAt(result)] > 1) {
                // 当字符已经出现过2次了
                result++;
            }
        }
        return result == s.length() ? ' ' : s.charAt(result);
    }

}
