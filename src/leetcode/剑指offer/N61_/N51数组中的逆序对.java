package leetcode.剑指offer.N61_;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/7 7:50
 */
public class N51数组中的逆序对 {

    @Test
    public void test() {
        Assert.assertEquals(5, reversePairs(new int[]{3, 4, 5, 6, 7}));
    }

    int result = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return result;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        // --------------- 优化-提前返回 ---------------
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        // --------------- 优化-临时数组可以直接创建一个长度和nums相同的，然后传进来 ---------------
        int[] ints = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            ints[i - l] = nums[i];
        }
        int i = l;
        int j = mid + 1;
        for (int m = l; m <= r; m++) {
            if (i > mid) {
                nums[m++] = ints[j++ - l];
            } else if (j > r) {
                nums[m++] = ints[i++ - l];
            } else if (ints[i - l] <= ints[j - l]) {
                nums[m] = ints[i++ - l];
            } else {
                // 计算逆序
                result += mid - i + 1;
                nums[m] = ints[j++ - l];
            }
        }
    }

}
