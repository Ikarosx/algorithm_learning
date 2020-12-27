package leetcode.周赛.w221;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 *
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * 示例 2：
 *
 * 输入：grid = [[-1]]
 * 输出：[-1]
 * 解释：球被卡在箱子左侧边上。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 *
 * @author Ikarosx
 * @date 2020/12/27 10:39
 */
public class N5210球会落在何处 {


    public int[] findBall(int[][] grid) {
        // 1表示向右
        // -1表示向左
        // 卡住的话为当前1，右边超出范围或者右边为-1
        int columnLength = grid[0].length;
        int[] answer = new int[columnLength];
        for (int i = 0; i < columnLength; i++) {
            int row = 0;
            int column = i;
            while (true) {
                if (row == grid.length) {
                    answer[i] = column;
                    break;
                }
                if (grid[row][column] == 1 && column + 1 < columnLength && grid[row][column + 1] == 1) {
                    // 往右下走
                    row++;
                    column++;
                    continue;
                }
                if (grid[row][column] == -1 && column - 1 >= 0 && grid[row][column - 1] == -1) {
                    // 往左下走
                    row++;
                    column--;
                    continue;
                }
                answer[i] = -1;
                break;
            }
        }
        return answer;
    }
}
