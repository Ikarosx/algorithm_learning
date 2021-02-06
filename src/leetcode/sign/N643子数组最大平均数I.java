package leetcode.sign;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 通过次数40,415提交次数90,666
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/4 15:38
 */
public class N643子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        while (r < nums.length - 1) {
            sum -= nums[l++];
            sum += nums[++r];
            max = Math.max(max, sum);
        }
        return 1.0 * max / k;
    }
}
