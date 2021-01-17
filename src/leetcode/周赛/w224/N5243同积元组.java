package leetcode.周赛.w224;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (3,4,2,6) , (3,4,6,2) , (4,3,6,2)
 * 示例 2：
 *
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * 示例 3：
 *
 * 输入：nums = [2,3,4,6,8,12]
 * 输出：40
 * 示例 4：
 *
 * 输入：nums = [2,3,5,7]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * nums 中的所有元素 互不相同
 *
 * @author Ikarosx
 * @date 2021/1/17 10:36
 */
public class N5243同积元组 {

    @Test
    public void test() {
        Assert.assertEquals(8, tupleSameProduct(new int[]{2, 3, 4, 6}));
        Assert.assertEquals(40, tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
    }

    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r && r - l > 2) {
            int tempSum = nums[l] * nums[r];
            int ll = l + 1;
            int rr = r - 1;
            while (ll < rr) {
                int sum = nums[ll] * nums[rr];
                if (sum < tempSum) {
                    ll++;

                } else if (sum > tempSum) {
                    rr--;

                } else {
                    System.out.printf("%s-%s-%s-%s%n", nums[l], nums[ll], nums[rr], nums[r]);
                    result++;
                    rr--;
                    ll++;
                }
            }
            r--;
        }
        l = 1;
        r = nums.length - 1;
        while (l < r && r - l > 2) {
            int tempSum = nums[l] * nums[r];
            int ll = l + 1;
            int rr = r - 1;
            while (ll < rr) {
                int sum = nums[ll] * nums[rr];
                if (sum < tempSum) {
                    ll++;

                } else if (sum > tempSum) {
                    rr--;

                } else {
                    System.out.printf("%s-%s-%s-%s%n", nums[l], nums[ll], nums[rr], nums[r]);
                    result++;
                    rr--;
                    ll++;
                }
            }
            l++;
        }
        return result * 8;
    }
}
