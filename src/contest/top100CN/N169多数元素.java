package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author Ikarosx
 * @date 2020/7/12 20:23
 */
public class N169多数元素 {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int count = 1;
        int moer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == moer) {
                count++;
            } else if (--count == 0) {
                moer = nums[i];
                count = 1;
            }
        }
        return moer;
    }
}
