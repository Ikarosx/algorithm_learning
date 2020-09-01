package contest.超级码力在线编程大赛初赛2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/8/30 10:03
 */
public class C五字回文 {

    @Test
    public void test(){
        Assert.assertEquals(Fivecharacterpalindrome("abcba"), 1);
        Assert.assertEquals(Fivecharacterpalindrome("abcbabcccb"), 2);
    }

    /**
     * @param s: The given string
     *
     * @return: return the number of Five-character palindrome
     */
    public int Fivecharacterpalindrome(String s) {
        if (s == null || s.length() < 5) {
            return 0;
        }
        StringBuilder builder = new StringBuilder(s.substring(0, 5));
        int result = isPalindrome(builder.toString()) ? 1 : 0;
        for (int i = 5; i < s.length(); i++) {
            builder.deleteCharAt(0);
            builder.append(s.charAt(i));
            result += isPalindrome(builder.toString()) ? 1 : 0;
        }
        return result;
    }

    private boolean isPalindrome(String string) {
        if (string.charAt(0) != string.charAt(4)) {
            return false;
        }
        if (string.charAt(1) != string.charAt(3)) {
            return false;
        }
        if (string.charAt(0) == string.charAt(1) || string.charAt(1) == string.charAt(2)
            || string.charAt(0) == string.charAt(2)) {
            return false;
        }
        return true;
    }


}
