package leetcode.周赛.w223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 *
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 *
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 * 示例 2：
 *
 * 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
 * 输出：2
 * 解释：不能对 source 执行交换操作。
 * source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。
 * 示例 3：
 *
 * 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == source.length == target.length
 * 1 <= n <= 105
 * 1 <= source[i], target[i] <= 105
 * 0 <= allowedSwaps.length <= 105
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 *
 * @author Ikarosx
 * @date 2021/1/10 10:48
 */
public class N5650执行交换操作后的最小汉明距离 {

    int[] fa;
    Map<Integer, List<Integer>> map;

    public int find(int x) {
        return fa[x] == x ? x : (fa[x] = find(fa[x]));
    }

    public void union(int x, int y) {
        int fx = find(fa[x]);
        int fy = find(fa[y]);
        fa[fx] = fy;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5},
            new int[][]{{0, 1}, {2, 3}}));
        Assert.assertEquals(2,
            minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{1, 3, 2, 4}, new int[][]{}));
        Assert.assertEquals(0,
            minimumHammingDistance(new int[]{5, 1, 2, 4, 3}, new int[]{1, 5, 4, 2, 3},
                new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}));
        Assert.assertEquals(8, minimumHammingDistance(new int[]{18, 67, 10, 36, 17, 62, 38, 78, 52},
            new int[]{3, 4, 99, 36, 26, 58, 29, 33, 74},
            new int[][]{{4, 7}, {3, 1}, {8, 4}, {5, 6}, {2, 8}, {0, 7}, {1, 6}, {3, 7}, {2, 5},
                {3, 0}, {8, 5}, {2, 1}, {6, 7}, {5, 1}, {3, 6}, {4, 0}, {7, 2}, {2, 6}, {4, 1},
                {3, 2}, {8, 6}, {8, 0}, {5, 3}, {1, 0}, {4, 6}, {8, 7}, {5, 7}, {3, 8}, {6, 0},
                {8, 1}, {7, 1}, {5, 0}, {4, 3}, {0, 2}}));

    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        fa = new int[source.length];
        map = new HashMap<>();
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
            map.putIfAbsent(i, new ArrayList<>());
        }
        // 并查集
        for (int[] allowedSwap : allowedSwaps) {
            union(allowedSwap[0], allowedSwap[1]);
        }
        for (int i = 0; i < fa.length; i++) {
            map.get(find(fa[i])).add(i);
        }
        int result = 0;
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            // value为一个集合中的下标
            List<Integer> value = entry.getValue();
            // 判断对应下标中的值有多少个不同
            HashMap<Integer, Integer> smap = new HashMap<>();
            for (Integer integer : value) {
                smap.put(source[integer], smap.getOrDefault(source[integer], 0) + 1);
                smap.put(target[integer], smap.getOrDefault(target[integer], 0) - 1);
            }
            for (Integer integer : smap.values()) {
                if (integer > 0) {
                    result += integer;
                }
            }
        }
        return result;
    }
}
