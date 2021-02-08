package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * 通过次数14,595提交次数33,858
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/8 0:49
 */
public class N978最长湍流子数组 {
    @Test
    public void test() {
        Assert.assertEquals(5, maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        Assert.assertEquals(2, maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        Assert.assertEquals(1, maxTurbulenceSize(new int[]{100}));
        Assert.assertEquals(5, maxTurbulenceSize(new int[]{4, 2, 10, 7, 8}));
        Assert.assertEquals(5, maxTurbulenceSize(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0}));
        Assert.assertEquals(1, maxTurbulenceSize(new int[]{1, 1, 1}));
    }

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return arr.length;
        }
        if (arr.length == 2) {
            return arr[0] == arr[1] ? 1 : 2;
        }
        int result = arr[0] == arr[1] ? 1 : 2;
        int count = arr[0] == arr[1] ? 1 : 2;
        for (int i = 1; i < arr.length - 1; i++) {
            int temp = 0;
            temp += arr[i - 1] > arr[i] ? 1 : arr[i - 1] < arr[i] ? -1 : -2;
            temp += arr[i] > arr[i + 1] ? 1 : arr[i] < arr[i + 1] ? -1 : -2;
            if (temp == 0) {
                if (count == 0) {
                    count = 3;
                } else {
                    count++;
                }
                result = Math.max(count, result);
            } else {
                count = 0;
            }
        }
        return result;
    }
}
