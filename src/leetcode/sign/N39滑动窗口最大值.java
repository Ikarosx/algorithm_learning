package leetcode.sign;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import org.junit.Test;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/2 12:56
 */
public class N39滑动窗口最大值 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 11, 20, 15}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, -2}, 2)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            k = nums.length;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[(nums.length - k) >= 0 ? nums.length - k + 1 : 1];

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if (deque.isEmpty()) {
                deque.addFirst(num);
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.add(num);
        }
        result[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            int num = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.add(num);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;

    }
}
