package contest.top100CN;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author Ikaros
 * @date 2020/6/28 9:58
 */
public class N15三数之和 {
    @Test
    public void test() {
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int current = nums[i];
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int temp = current + nums[L] + nums[R];
                if (temp == 0) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(current);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L + 1] == nums[L]) {
                        ++L;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        --R;
                    }
                    ++L;
                    --R;
                } else if (temp < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return lists;
    }
}
