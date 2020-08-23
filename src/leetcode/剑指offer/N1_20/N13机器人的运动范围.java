package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，
 * 机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 16:38
 */
public class N13机器人的运动范围 {

    @Test
    public void test() {
        assert movingCount(2, 3, 1) == 3;
        assert movingCount(3, 1, 0) == 1;
    }

    // --------------- 优化-只需要向右向下 ---------------
    int[][] position = {{0, 1}, {1, 0}};

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCountImpl(m, n, 0, 0, k, visited);
    }

    private int movingCountImpl(int m, int n, int row, int column, int k, boolean[][] visited) {
        // 不能进入行列之和大于K
        if (row >= m || column >= n || visited[row][column] || countNum(row, column) > k) {
            return 0;
        }
        int max = 0;
        // 记录访问过的
        visited[row][column] = true;
        for (int[] ints : position) {
            // 累加
            max += movingCountImpl(m, n, row + ints[0], column + ints[1], k, visited);
        }
        // 还得加上自己
        return max + 1;
    }

    /**
     * 计算各个位数相加
     */
    private int countNum(int row, int column) {
        int result = 0;
        while (row != 0 || column != 0) {
            result += row % 10;
            row /= 10;
            result += column % 10;
            column /= 10;
        }
        return result;
    }
}
