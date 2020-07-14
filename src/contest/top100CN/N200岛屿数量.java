package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author Ikarosx
 * @date 2020/7/14 7:58
 */
public class N200岛屿数量 {
    int[][] position = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            int column = grid[0].length;
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] ints : position) {
            dfs(grid, i + ints[0], j + ints[1]);
        }
    }
}
