package leetcode.周赛.w222;

import org.junit.Assert;
import org.junit.Test;

/**
 * 我们称一个分割整数数组的方案是 好的 ，当它满足：
 *
 * 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
 * left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
 * 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1]
 * 输出：1
 * 解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,2,2,5,0]
 * 输出：3
 * 解释：nums 总共有 3 种好的分割方案：
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * 示例 3：
 *
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：没有好的分割方案。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/3 12:14
 */
public class N5643将数组分成三个子数组的方案数 {

    @Test
    public void test() {
        Assert.assertEquals(1, waysToSplit(new int[]{1, 1, 1}));
        Assert.assertEquals(3, waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        Assert.assertEquals(0, waysToSplit(new int[]{3, 2, 1}));
    }

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int mod = 1000000007;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        int ret = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (preSum[mid] - preSum[i] < preSum[i]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (preSum[l] - preSum[i] < preSum[i]) {
                l++;
                if (l == n - 1) {
                    break;
                }
            }

            int minv = l;
            r = n - 1;
            while (r - l > 1) {
                int mid = (l + r) / 2;
                int right = (preSum[n - 1] - preSum[mid]);
                int left = (preSum[mid] - preSum[i]);
                if (right >= left) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            int diff = (preSum[n - 1] - preSum[l]) - (preSum[l] - preSum[i]);
            if (diff < 0) {
                continue;
            }
            int maxv = l;

            ret += maxv - minv + 1;
            ret %= mod;
        }
        return ret;
    }
}
