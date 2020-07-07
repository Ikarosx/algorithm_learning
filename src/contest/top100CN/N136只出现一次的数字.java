package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author Ikarosx
 * @date 2020/7/7 8:40
 */
public class N136只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
