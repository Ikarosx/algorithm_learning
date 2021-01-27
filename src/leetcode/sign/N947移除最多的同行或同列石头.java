package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * <p>
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * <p>
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * 示例 2：
 * <p>
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * 示例 3：
 * <p>
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 104
 * 不会有两块石头放在同一个坐标点上
 * 通过次数22,062提交次数36,149
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/23 11:24
 */
public class N947移除最多的同行或同列石头 {

    Map<Integer, Integer> fa;
    int count;

    public int find(int x) {
        if (!fa.containsKey(x)) {
            count++;
            fa.put(x, x);
        }
        if (fa.get(x) != x) {
            fa.put(x, find(fa.get(x)));
        }
        return fa.get(x);
    }

    public void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx != yy) {
            count--;
        }
        fa.put(xx, yy);
    }

    @Test
    public void test() {
        Assert.assertEquals(5,
                removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        Assert.assertEquals(5,
                removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }

    public int removeStones(int[][] stones) {
        // 横列符合都可以合并
        // 最后统计连通分量的数量
        count = 0;
        fa = new HashMap<>();
        int id = 0;
        for (int[] stone : stones) {
            union(stone[0] + 10001, stone[1]);
        }
        return stones.length - count;
    }
}
