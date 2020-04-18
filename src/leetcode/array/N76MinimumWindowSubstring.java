package leetcode.array;

/**
 * Given a string S and a string T, find the minimum window
 * in S which will contain all the characters in T in
 * complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all
 * characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there
 * will always be only one unique minimum window in S.
 *
 * @author Ikaros
 */
public class N76MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] srcHash = new int[256];
        // 记录目标字符串每个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            srcHash[t.charAt(i)]++;
        }
        int start = 0, i = 0;
        // 用于记录窗口内每个字母出现的次数
        int[] destHash = new int[256];
        int found = 0;
        int begin = -1, end = s.length(), minLength = s.length();
        for (start = i = 0; i < s.length(); i++) {
            // 每来一个字符给它的出现次数加1
            destHash[s.charAt(i)]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if (destHash[s.charAt(i)] <= srcHash[s.charAt(i)]) {
                found++;
            }
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if (found == t.length()) {
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while (start < i && destHash[s.charAt(start)] > srcHash[s.charAt(start)]) {
                    destHash[s.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if (i - start < minLength) {
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[s.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : s.substring(begin, end + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        
    }
}
