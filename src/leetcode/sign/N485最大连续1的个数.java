package leetcode.sign;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *  
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/15 23:32
 */
public class N485最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                result = Math.max(count, result);
            } else {
                count = 0;
            }
        }
        return result;
    }
}
