package leetcode.周赛.w227;

import org.junit.Assert;
import org.junit.Test;

/**
 * 你正在玩一个单人游戏，面前放置着大小分别为 a​​​​​​、b 和 c​​​​​​ 的 三堆 石子。
 * <p>
 * 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
 * <p>
 * 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 2, b = 4, c = 6
 * 输出：6
 * 解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
 * - 从第一和第三堆取，石子状态现在是 (1, 4, 5)
 * - 从第一和第三堆取，石子状态现在是 (0, 4, 4)
 * - 从第二和第三堆取，石子状态现在是 (0, 3, 3)
 * - 从第二和第三堆取，石子状态现在是 (0, 2, 2)
 * - 从第二和第三堆取，石子状态现在是 (0, 1, 1)
 * - 从第二和第三堆取，石子状态现在是 (0, 0, 0)
 * 总分：6 分 。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 4, c = 6
 * 输出：7
 * 解释：石子起始状态是 (4, 4, 6) ，最优的一组操作是：
 * - 从第一和第二堆取，石子状态现在是 (3, 3, 6)
 * - 从第一和第三堆取，石子状态现在是 (2, 3, 5)
 * - 从第一和第三堆取，石子状态现在是 (1, 3, 4)
 * - 从第一和第三堆取，石子状态现在是 (0, 3, 3)
 * - 从第二和第三堆取，石子状态现在是 (0, 2, 2)
 * - 从第二和第三堆取，石子状态现在是 (0, 1, 1)
 * - 从第二和第三堆取，石子状态现在是 (0, 0, 0)
 * 总分：7 分 。
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 8, c = 8
 * 输出：8
 * 解释：最优的一组操作是连续从第二和第三堆取 8 回合，直到将它们取空。
 * 注意，由于第二和第三堆已经空了，游戏结束，不能继续从第一堆中取石子。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b, c <= 105
 *
 * @author Ikarosx
 * @date 2021/2/7 10:52
 */
public class N5673移除石子的最大得分 {
    @Test
    public void test() {
        Assert.assertEquals(6, maximumScore(2, 4, 6));
        Assert.assertEquals(7, maximumScore(4, 4, 6));
        Assert.assertEquals(8, maximumScore(1, 8, 8));
        Assert.assertEquals(8, maximumScore(100000, 100000, 100000));
    }

    public int maximumScore(int a, int b, int c) {
        // 每次取最小和最大的
        int result = 0;
        while (true) {
            int max = Math.max(Math.max(a, b), c);
            int min = Math.min(Math.min(a, b), c);
            int middle = a + b + c - max - min;
            if (min == 0 && middle == 0) {
                break;
            }
            if (min == 0) {
                result += Math.min(middle, max);
                break;
            } else {
                min--;
                max--;
                a = min;
                b = middle;
                c = max;
                result++;
            }

        }
        return result;
    }
}
