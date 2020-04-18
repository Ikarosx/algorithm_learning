package leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each
 * element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must
 * do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first
 * two elements of nums
 * being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned
 * length. Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first
 * five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned
 * length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your
 * answer is an array?
 * <p>
 * Note that the input array is passed in by reference,
 * which means modification
 * to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making
 * a copy) int len =
 * removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be
 * known by the caller. //
 * using the length returned by your function, it prints the
 * first len elements.
 * for (int i = 0; i < len; i++) { print(nums[i]); }
 *
 * @author Ikaros
 */
public class N26RemoveDuplicatesFromSortedArray {
    @Test
    public void test() {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array));
    }
    
    /**
     * 20200410
     *
     * @param nums
     *
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 去除数组里的重复元素，返回新长度n，且顺序稳定
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        result++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }
    
    // 非有序数组。。。
    public int removeDuplicates1(int[] nums) {
        // [0...length)表示不重复数值
        int length = 0;
        // 遍历数组所有值，将nums[i]与[0...length)中所有值比较，假如都没有出现则交换length与i,length++
        one:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[j] == nums[i])
                    continue one;
            }
            swap(nums, i, length++);
        }
        return length;
    }
    
    // 有序数组 改进
    public int removeDuplicates2(int[] nums) {
        // [0...length)表示不重复数值
        int length = 1;
        if (nums.length == 0)
            length = 0;
        // 遍历数组中[i...nums.length)，假如下标为i不等于不重复数值中最后一个，即下标为length-1，则交换
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[length - 1])
                swap(nums, i, length++);
        }
        return length;
    }
    
    private static void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
    
}
