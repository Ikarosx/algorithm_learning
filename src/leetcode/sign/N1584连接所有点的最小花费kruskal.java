package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 * 通过次数6,915提交次数11,573
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/19 10:26
 */
public class N1584连接所有点的最小花费kruskal {

    int[] fa;
    // 此时有多少颗树
    int count;
    int sum = 0;

    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    public void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx != yy) {
            count--;
        }
        fa[xx] = yy;
    }

    class CostInfo {
        private int a;
        private int b;
        private int value;

        public CostInfo(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getValue() {
            return value;
        }

    }

    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        List<CostInfo> costInfos = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (i == j) {
                    continue;
                }
                costInfos.add(new CostInfo(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        costInfos.sort(Comparator.comparingInt(a -> a.value));

        // kruskal
        // 每次选择一条花费最小，且两点不属于同一棵树
        // 直至所有点同一棵树
        fa = new int[length];
        for (int i = 0; i < length; i++) {
            fa[i] = i;
        }
        count = length;
        // 直到只剩下一颗树
        for (CostInfo costInfo : costInfos) {
            if (find(costInfo.getA()) != find(costInfo.getB())) {
                union(costInfo.getA(), costInfo.getB());
                sum += costInfo.getValue();
                if (count == 1) {
                    break;
                }
            }
        }
        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(20,
                minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }


}
