package leetcode.周赛.w221;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.Test;

/**
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 *
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 *
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 *
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 *
 * TODO
 *
 * @author Ikarosx
 * @date 2020/12/27 11:26
 */
public class N5640与数组中元素的最大异或值 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(maximizeXor(new int[]{0, 1, 2, 3, 4},
            new int[][]{{3, 1}, {1, 3}, {2, 2}, {4, 7}, {5, 6}, {6, 5}, {0, 8}})));
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ints = new int[queries.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int[] query : queries) {
            int temp = query[0];
            int leThan = query[1];
            int max = -1;
            if (leThan < min) {
                ints[index++] = -1;
                continue;
            }
            if (map.get(temp + leThan) != null) {
                ints[index++] = map.get(temp + leThan);
                continue;
            }
            for (int num : nums) {
                if (num <= leThan) {
                    max = Math.max(max, temp ^ num);
                }
            }
            map.put(temp + leThan, max);
            ints[index++] = max;
        }
        return ints;
    }
}
