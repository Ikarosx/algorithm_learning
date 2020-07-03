package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author Ikaros
 * @date 2020/7/3 7:55
 */
public class N62不同路径 {
    public int uniquePaths(int m, int n) {
        // n行m列
        int[][] ints = new int[n][m];
        ints[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    ints[i][j] += ints[i][j - 1];
                }
                if (i > 0) {
                    ints[i][j] += ints[i - 1][j];
                }
            }
        }
        return ints[n - 1][m - 1];
    }
    
    @Test
    public void test() {
        System.out.println(uniquePaths(1, 1));
    }
}
