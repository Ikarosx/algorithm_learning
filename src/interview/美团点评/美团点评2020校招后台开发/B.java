package interview.美团点评.美团点评2020校招后台开发;

/**
 * @author Ikarosx
 * @date 2020/9/28 10:48
 */

import java.util.Scanner;
import org.junit.Test;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String p = scanner.nextLine();
            String s = scanner.nextLine();
            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i <= p.length(); i++) {
                for (int j = 1; j <= s.length(); j++) {
                    char pc = p.charAt(i - 1);
                    char tc = s.charAt(j - 1);
                    if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        if (i >= 2) {
                            dp[i][j] |= dp[i - 2][j];
                        }
                        if (i >= 2 && j >= 1 && (p.charAt(i - 2) == tc || p.charAt(i - 2) == '.')) {
                            dp[i][j] |= dp[i][j - 1];
                        }
                        // dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = pc == tc && dp[i - 1][j - 1];
                    }
                }
            }
            System.out.println(dp[p.length()][s.length()] ? "1" : "0");
        }
        scanner.close();
    }

    @Test
    public void test(){
        System.out.println(isMatch("aab", "c*a*b*"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                char pc = p.charAt(i - 1);
                char tc = s.charAt(j - 1);
                if (pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (i >= 2) {
                        dp[i][j] |= dp[i - 2][j];
                    }
                    if (i >= 2 && j >= 1 && (p.charAt(i - 2) == tc || p.charAt(i - 2) == '.')) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                    // dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = pc == tc && dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}