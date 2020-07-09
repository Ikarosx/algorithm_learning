package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author Ikarosx
 * @date 2020/7/9 7:44
 */
public class N152乘积最大子数组 {
    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{-3, 2, -4}));
    }
    
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num * max, num);
            min = Math.min(num * min, num);
            result = Math.max(result, max);
        }
        
        return result;
    }
}
