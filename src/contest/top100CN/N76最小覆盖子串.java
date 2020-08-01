package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author Ikarosx
 * @date 2020/8/1 8:34
 */
public class N76最小覆盖子串 {

    @Test
    public void test() {
        System.out.println(minWindow("A", "ABC"));
    }

    public String minWindow(String s, String t) {
        int[] tchars = new int[256];
        int[] schars = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tchars[t.charAt(i)]++;
        }
        int minLen = Integer.MAX_VALUE;
        int begin = 0;
        int left = 0;
        int right = 0;
        int sLen = s.length();
        //滑动窗口内部包含多少T的字符
        int distance = 0;
        // [left, right)
        while (right < sLen) {
            // 右扩
            if (tchars[s.charAt(right)] == 0) {
                right++;
                continue;
            }
            if (schars[s.charAt(right)] < tchars[s.charAt(right)]) {
                distance++;
            }
            schars[s.charAt(right)]++;
            right++;
            while (distance == t.length()) {
                // 左缩
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                if (tchars[s.charAt(left)] == 0) {
                    left++;
                    continue;
                }

                if (schars[s.charAt(left)] == tchars[s.charAt(left)]) {
                    distance--;
                }
                schars[s.charAt(left)]--;
                left++;
            }

        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

}
