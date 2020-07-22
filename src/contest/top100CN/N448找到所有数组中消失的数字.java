package contest.top100CN;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author Ikarosx
 * @date 2020/7/21 8:25
 */
public class N448找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                integers.add(i + 1);
            }
        }
        return integers;
    }
}
