package contest.top100CN;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

/**
 * @author Ikarosx
 * @date 2020/7/17 7:49
 */
public class N239滑动窗口最大值 {
    @Test
    public void test() {
        
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
    
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        
        // init deque and output
        this.nums = nums;
        for (int i = 0; i < k; i++) {
            // 从末尾移除比当前数还小的
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();
            }
            // 把当前数的索引添加进去
            deq.addLast(i);
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[deq.getFirst()];
        
        // build output
        for (int i = k; i < n; i++) {
            if (deq.getFirst() < i - k + 1) {
                deq.pollFirst();
            }
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();
            }
            // 把当前数的索引添加进去
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
    
}
