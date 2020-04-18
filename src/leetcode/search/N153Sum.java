package leetcode.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a,
 * b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Ikaros
 */
public class N153Sum {
    /**
     * 我的实现超时了
     * <p>
     * 别人的思路
     * Step1：将数组排序
     * Step2：以第一个数p1作为最外层循环，其中如果第一个数如果为正，说明和不可能为0
     * Step3：定义中间指针p2，尾指针p3，
     * <p>
     * 如果num[p2] + num[p3] > -nums[p1]，则说明和太小了，应该往数值大的方向的移动，p2++
     * 如果num[p2] + num[p3] < -nums[p1]，则说明和太大了，应该往数值小的方向的移动，p3--
     * 如果num[p2] + num[p3] = -nums[p1]，将结果保存，同时将p2、p3往中间移动，为了保证结果的唯一性，需要跳过重复元素
     *
     * @param nums
     *
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 第一个数不可能是正数
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > -nums[i]) {
                    r--;
                } else if (sum < -nums[i]) {
                    l++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    l++;
                    while (r - 1 > l && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    r--;
                }
            }
            
        }
        return result;
    }
    
    public static void main(String[] args) {
        N153Sum xN153Sum = new N153Sum();
        int[] arr = {0,-4,-1,-4,-2,-3,2};
        System.out.println(xN153Sum.threeSum(arr).toString());
    }
}
