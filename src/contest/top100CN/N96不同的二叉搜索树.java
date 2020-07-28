package contest.top100CN;

/**
 * TODO
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author Ikarosx
 * @date 2020/7/28 7:40
 */
public class N96不同的二叉搜索树 {
    public int numTrees(int n) {
        // 二叉树可以看做是数组，以此dp
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
                
            }
        }
        return dp[n];
    }
}
