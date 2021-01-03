package leetcode.序号.n100;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/3 21:12
 */
public class N125验证回文串 {

    @Test
    public void test() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertTrue(isPalindrome("rac a car"));
        Assert.assertTrue(isPalindrome("rac aa car"));
        Assert.assertFalse(isPalindrome("rac ac car"));
        Assert.assertTrue(isPalindrome(".."));
        Assert.assertFalse(isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        return builder.toString().equals(builder.reverse().toString());
    }
}
