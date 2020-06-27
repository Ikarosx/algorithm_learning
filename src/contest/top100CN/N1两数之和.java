package contest.top100CN;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author Ikaros
 * @date 2020/06/23 22:58
 */
public class N1两数之和 {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null) {
                return new int[]{integer, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
