package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * @author Ikarosx
 * @date 2020/7/17 7:41
 */
public class N238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        // res目前存储左边
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }
}
