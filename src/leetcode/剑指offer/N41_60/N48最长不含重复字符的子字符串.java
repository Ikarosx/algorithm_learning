package leetcode.剑指offer.N41_60;

import org.junit.Assert;
import org.junit.Test;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * s.length <= 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/6 9:27
 */
public class N48最长不含重复字符的子字符串 {

    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(1, lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        // TODO --------------- 优化-哈希表 ---------------
        // TODO --------------- 优化-动态规划 ---------------
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = new char[256];
        int start = 0;
        int result = 0;
        // 判断每个字符
        for (int i = 0; i < s.length(); i++) {
            // 字符在当前滑动窗口中不存在，i++
            char c = s.charAt(i);
            if (chars[c] == 0) {
                // 没有出现过
                // 字符出现次数+1
                chars[c]++;
                if (i == s.length() - 1) {
                    // 如果是最后一个字符
                    result = i - start + 1 > result ? i - start + 1 : result;
                }
            } else {
                // 字符已经出现过了
                // 更新结果
                result = i - start > result ? i - start : result;
                // 字符在滑动窗口中存在，左边右缩到当前字符的位置+1
                while (s.charAt(start) != c) {
                    // 当左边字符不等于当前字符时
                    chars[s.charAt(start)]--;
                    start++;
                }
                // 当前start对应字符为c，start应该+1
                start++;
            }
        }
        return result;
    }

}
