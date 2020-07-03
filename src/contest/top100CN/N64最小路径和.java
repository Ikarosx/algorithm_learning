package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author Ikaros
 * @date 2020/7/3 8:16
 */
public class N64最小路径和 {
    
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int length = grid[i].length;
            for (int j = 0; j < length; j++) {
                if (j > 0 && i > 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                } else if (j > 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (i > 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
