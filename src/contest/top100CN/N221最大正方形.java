package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author Ikarosx
 * @date 2020/7/16 8:48
 */
public class N221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}
