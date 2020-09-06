package leetcode.剑指offer.N41_60;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/6 9:16
 */
public class N47礼物的最大价值 {

    int result = 0;

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 原数组上修改
        // 使得grid[i][j]即为最大值
        // 修改第一列
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 修改第一行
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 从第1行第1列开始计算(下标为0
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += grid[i - 1][j] > grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    // 超时
    private void dfs(int[][] grid, int row, int column, int sum) {
        if (row == grid.length || column == grid[0].length) {
            result = sum > result ? sum : result;
            return;
        }
        dfs(grid, row + 1, column, sum + grid[row][column]);
        dfs(grid, row, column + 1, sum + grid[row][column]);
    }

}
