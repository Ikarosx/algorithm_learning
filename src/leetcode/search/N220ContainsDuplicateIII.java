package leetcode.search;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are
 * two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at
 * most t and the absolute difference between i and j is at
 * most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class N220ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) (nums[i - k]));
            }
            
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2147483648, -2147483647};
        System.out.println(containsNearbyAlmostDuplicate(arr, 3, 3));
    }
}
