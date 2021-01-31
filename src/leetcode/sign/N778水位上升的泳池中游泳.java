package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * <p>
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * <p>
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 * <p>
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 * 示例2:
 * <p>
 * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * 输出: 16
 * 解释:
 * 0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * <p>
 * 最终的路线用加粗进行了标记。
 * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 *  
 * <p>
 * 提示:
 * <p>
 * 2 <= N <= 50.
 * grid[i][j] 是 [0, ..., N*N - 1] 的排列。
 * 通过次数8,449提交次数16,151
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/30 10:02
 */
public class N778水位上升的泳池中游泳 {
    int[] fa;

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
        Assert.assertEquals(3, swimInWater(new int[][]{{0, 2}, {1, 3}}));
    }

    public int swimInWater(int[][] grid) {
        // 并查集，每加一次计算可以合并的点，有两个条件，和已经加入的点相邻，以及时间符合
        int n = grid.length;
        fa = new int[n * n];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        List<PointInfo> pointInfos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                pointInfos.add(new PointInfo(i, j, grid[i][j]));
            }
        }
        pointInfos.sort(Comparator.comparingInt(PointInfo::getValue));
        int last = n * n - 1;
        int count = 0;
        while (find(last) != find(0)) {
            PointInfo pointInfo = pointInfos.get(count);
            Integer a = pointInfo.a;
            Integer b = pointInfo.b;
            Integer value = pointInfo.value;
            if (a > 0 && value > grid[a - 1][b]) {
                union(a * n + b, (a - 1) * n + b);
            }
            if (b > 0 && value > grid[a][b - 1]) {
                union(a * n + b, (a) * n + b - 1);
            }
            if (a < n - 1 && value > grid[a + 1][b]) {
                union(a * n + b, (a + 1) * n + b);
            }
            if (b < n - 1 && value > grid[a][b + 1]) {
                union(a * n + b, (a) * n + b + 1);
            }
            count++;
        }
        return count - 1;
    }

    class PointInfo {
        private Integer a;
        private Integer b;
        private Integer value;

        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }

        public Integer getValue() {
            return value;
        }

        public PointInfo(Integer a, Integer b, Integer value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }
}
