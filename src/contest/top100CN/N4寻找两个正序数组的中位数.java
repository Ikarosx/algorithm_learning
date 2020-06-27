package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author Ikaros
 * @date 2020/06/24 00:24
 */
public class N4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 归并排序
        int[] ints = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < ints.length; k++) {
            if (i >= nums1.length) {
                ints[k] = nums2[j++];
            } else if (j >= nums2.length) {
                ints[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                ints[k] = nums1[i++];
            } else {
                ints[k] = nums2[j++];
            }
            // 提前返回
        }
        if (ints.length == 1) {
            return ints[0];
        }
        if ((ints.length & 1) == 0) {
            return (ints[ints.length / 2] + ints[ints.length / 2 - 1]) / 2.0;
        } else {
            return ints[ints.length / 2];
        }
    }
}
