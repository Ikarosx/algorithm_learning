package leetcode.序号.n400;

import org.junit.Test;

/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 示例 1：
 *
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/island.png">
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：4
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0]]
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * <p>
 * 相关标签：
 * 深度优先搜索
 * 广度优先搜索
 * 数组
 * 矩阵
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author Ikarosx
 * @date 2021/7/8
 */
public class N463岛屿的周长 {
    @Test
    public void test() {
        System.out.println(islandPerimeter(new int[][]{{0, 1}}));
    }

    public int islandPerimeter(int[][] grid) {
        // 遍历判断所有岛屿，每个岛屿初始化4条边
        // 每有一个岛屿相邻，就减少一条边
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int k = grid[i][j];
                if (k == 0) {
                    continue;
                }
                int c = 4;
                c -= neighborLand(grid, i, j);
                result += c;
            }
        }
        return result;

    }

    private int neighborLand(int[][] grid, int i, int j) {
        int[][] array = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int result = 0;
        for (int[] ints : array) {
            int x = ints[0];
            int y = ints[1];
            if (i + x >= 0 && j + y >= 0 && i + x <= grid.length - 1 && j + y <= grid[0].length - 1 && grid[i + x][j + y] == 1) {
                result++;
            }

        }
        return result;
    }
}