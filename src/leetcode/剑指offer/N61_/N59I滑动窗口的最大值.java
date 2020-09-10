package leetcode.剑指offer.N61_;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.Test;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/10 21:12
 */
public class N59I滑动窗口的最大值 {

    @Test
    public void test() {
        System.out
            .println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        int r = k - 1;
        deque.add(nums[0]);
        for (int i = 1; i < k; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);
        }
        int[] ints = new int[nums.length - k + 1];
        ints[0] = deque.peekFirst();
        for (; r < nums.length - 1; r++) {
            int num = nums[r + 1];
            // 弹出左边
            // 如果当前值等于左边，左边弹出
            if (deque.peekFirst() == nums[l++]) {
                deque.pollFirst();
            }
            // 插入右边
            // 如果右端比当前值小，持续弹出直到右端大于等于当前值
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);
            ints[r - k + 2] = deque.peekFirst();
        }
        return ints;
    }

}
