package leetcode.剑指offer.N61_;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author Ikarosx
 * @date 2020/9/8 8:26
 */
public class N53I在排序数组中查找数字 {

    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public int search1(int[] nums, int target) {
        // 二分查找
        // 查找右边界
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (j - i) / 2 + i;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        // 查找左边界
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j;
        return right - left + 1;
    }
}
