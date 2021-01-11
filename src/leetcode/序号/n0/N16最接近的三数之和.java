package leetcode.序号.n0;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/11 17:22
 */
public class N16最接近的三数之和 {

    @Test
    public void test() {
        Assert.assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[l] + nums[r];
                // 如果和为 target 直接返回答案
                int sum = temp + num;
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - sum) < min) {
                    result = sum;
                    min = Math.abs(target - sum);
                }
                if (sum <= target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
