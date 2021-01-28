package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

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
public class N1584连接所有点的最小花费Prim {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int sum = 0;
        PriorityQueue<CostInfo> costInfos = new PriorityQueue<>();
        boolean[] visited = new boolean[length];
        costInfos.add(new CostInfo(0, 0));
        // Prim
        // 分成两个集合，一部分为未选中，一部分选中
        // 每次从未选中的点中选择一个与已经选中的点的其中一点组成最短
        // 并加入选中的点
        // 直至所有点同一棵树
        // 未选中
        int n = length;
        while (!costInfos.isEmpty() && n > 0) {
            CostInfo costInfo = costInfos.poll();
            if (visited[costInfo.index]) {
                // 如果访问过
                continue;
            }
            sum += costInfo.d;
            visited[costInfo.index] = true;
            n--;
            for (int i = 0; i < length; i++) {
                if (visited[i]) {
                    continue;
                }
                int dis = Math.abs(points[costInfo.index][0] - points[i][0]) + Math.abs(points[costInfo.index][1] - points[i][1]);
                costInfos.add(new CostInfo(dis, i));
            }
        }
        return sum;


    }

    class CostInfo implements Comparable<CostInfo> {
        // 距离
        private int d;
        // 下标
        private int index;

        public CostInfo(int d, int index) {
            this.d = d;
            this.index = index;
        }

        @Override
        public int compareTo(CostInfo o) {
            return d - o.d;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(20,
                minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        Assert.assertEquals(18,
                minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
    }


}
