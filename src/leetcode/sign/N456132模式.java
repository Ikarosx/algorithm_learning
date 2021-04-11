package leetcode.sign;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * @author Ikarosx
 * @date 2021/03/24
 */
public class N456132模式 {
    @Test
    public void test() {
        Assert.assertFalse(find132pattern(new int[]{1, 2, 3, 4}));
        Assert.assertTrue(find132pattern(new int[]{3, 1, 4, 2}));
        Assert.assertTrue(find132pattern(new int[]{-1, 3, 2, 0}));
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }
}
