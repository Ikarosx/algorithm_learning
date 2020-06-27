package contest.top100;

/**
 * @author Ikaros
 * @date 2020/6/1 20:19
 */
public class N152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = max;
        for (int i = 1; i < nums.length; i++) {
            // 取最小和最大，因为最小可能直接反转成最大
            int minProduct = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            int maxProduct = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = minProduct;
            max = maxProduct;
            result = Math.max(result, max);
        }
        return result;
    }
}
