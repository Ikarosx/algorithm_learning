package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/10 9:26
 */
public class N567字符串的排列 {
    @Test
    public void test () {
        Assert.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assert.assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        // 特判
        if (length1 > length2) {
            return false;
        }
        int[] ints1 = new int[256];
        int[] ints2 = new int[256];
        for (int i = 0; i < length1; i++) {
            ints1[s1.charAt(i)]++;
            ints2[s2.charAt(i)]++;
        }
        int l = 0;
        int r = length1;
        if (Arrays.equals(ints1, ints2)) {
            return true;
        }
        while (r < length2) {
            ints2[s2.charAt(l++)]--;
            ints2[s2.charAt(r++)]++;
            if (Arrays.equals(ints1, ints2)) {
                return true;
            }
        }
        return false;
    }
}
