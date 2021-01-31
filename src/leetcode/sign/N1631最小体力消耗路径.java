package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *  
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * 通过次数4,766提交次数13,118
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/29 0:13
 */
public class N1631最小体力消耗路径 {
    int[] fa;
    int count = 0;

    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    public void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        fa[xx] = yy;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    /**
     * floyd超时
     *
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        // kruskal，并查集，直到首尾结点一起
        int row = heights.length;
        int column = heights[0].length;
        fa = new int[row * column];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        List<Path> paths = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j != column - 1) {
                    paths.add(new Path(i * column + j, i * column + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])));
                }
                if (i != row - 1) {
                    paths.add(new Path(i * column + j, (i + 1) * column + j, Math.abs(heights[i][j] - heights[i + 1][j])));
                }
            }
        }
        paths.sort(Comparator.comparingInt(a -> a.d));
        for (Path path : paths) {
            if (find(path.a) != find(path.b)) {
                union(path.a, path.b);
                count = Math.max(path.d, count);
            }
            if (find(0) == find(fa.length - 1)) {
                break;
            }
        }
        return count;
    }

    class Path {
        private int a;
        private int b;
        private int d;

        public Path(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }
}

