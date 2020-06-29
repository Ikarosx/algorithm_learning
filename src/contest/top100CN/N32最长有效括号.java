package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author Ikaros
 * @date 2020/6/28 21:10
 */
public class N32最长有效括号 {
    @Test
    public void test() {
        System.out.println(longestValidParentheses("()"));
    }
    
    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
