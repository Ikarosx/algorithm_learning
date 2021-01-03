package leetcode.周赛.w222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 *
 * 提示：
 *
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 *
 * @author Ikarosx
 * @date 2021/1/3 10:40
 */
public class N5642大餐计数 {

    @Test
    public void test() {
        Assert.assertEquals(4, countPairs(new int[]{1, 3, 5, 7, 9}));
        Assert.assertEquals(15, countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
        Assert.assertEquals(3, countPairs(new int[]{1, 1, 1}));
        Assert.assertEquals(3, countPairs(new int[]{1, 1, 1, 2}));
        Assert.assertEquals(1, countPairs(new int[]{0, 2}));
        Assert.assertEquals(0, countPairs(new int[]{1}));
        Assert.assertEquals(17, countPairs(new int[]{1, 1, 3, 7, 15, 31, 63, 127, 255, 511}));
    }

    public int countPairs(int[] deliciousness) {
        // 测试用例有问题。。
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        for (int i = 1; i < 21; i++) {
            ints.add(ints.get(i - 1) * 2);
        }
        // map存储数量映射
        for (int i = 0; i < deliciousness.length; i++) {
            int num = deliciousness[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] intValues = new int[map.size()];
        int index = 0;
        for (Integer integer : map.keySet()) {
            intValues[index++] = integer;
        }
        // 1 3 7
        long result = 0;
        for (Integer anInt : ints) {
            for (int intValue : intValues) {
                int i = anInt - intValue;
                if (map.containsKey(i)) {
                    Integer result1 = map.get(i);
                    if (intValue == i) {
                        result += result1 * (result1 - 1);
                    } else {
                        result += result1 * map.get(intValue);
                    }
                }
            }
        }
        return (int) ((result / 2) % (1000000007));
    }
}
