package contest.top100;

import org.junit.Test;

/**
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by
 * water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges
 * of the grid are all surrounded by water.
 *
 * @author Ikaros
 * @date 2020/6/12 9:18
 */
public class N200NumberOfIslands {
    int[][] visit;
    int result = 0;
    
    @Test
    public void test() {
    
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return result;
        }
        visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(i, j, grid, grid.length, grid[0].length, true);
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, char[][] grid, int row, int column, boolean flag) {
        if (i >= row || i < 0 || j >= column || j < 0 || visit[i][j] == 1 || grid[i][j] == '0') {
            return;
        }
        if (flag) {
            result++;
        }
        visit[i][j] = 1;
        dfs(i - 1, j, grid, row, column, false);
        dfs(i + 1, j, grid, row, column, false);
        dfs(i, j - 1, grid, row, column, false);
        dfs(i, j + 1, grid, row, column, false);
    }
}
