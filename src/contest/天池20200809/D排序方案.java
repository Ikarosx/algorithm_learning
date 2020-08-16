package contest.天池20200809;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/8/9 11:05
 */
public class D排序方案 {

    @Test
    public void solution() {
        System.out.println(sortedArrangement(new int[]{1, 3, 5, 7, 9, -8, -9}));
    }

    public long sortedArrangement(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        // nums[0]最小,nums[i - 1]最大
        queue.add(nums[0]);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num >= queue.peekLast()) {
                // 比最大还大
                // 直接放后面
                queue.addLast(num);
                result++;
            } else if (num <= queue.peekFirst()) {
                // 比最小还小
                // 直接放前面
                queue.addFirst(num);
                result++;
            } else {
                // 在中间
                int size = queue.size();
                Queue<Integer> integers = new LinkedList<>();
                while (queue.peekFirst() < num) {
                    integers.add(queue.pollFirst());
                }
                if (integers.size() < size - integers.size()) {
                    int minSize = integers.size();
                    integers.add(num);
                    int count = 1;
                    while (i + 1 < nums.length && nums[i + 1] > num && nums[i + 1] < queue
                        .peekFirst()) {
                        i++;
                        integers.add(nums[i + 1]);
                        count++;
                    }
                    result += minSize * 2 + count;
                    while (!integers.isEmpty()) {
                        queue.addFirst(integers.poll());
                    }
                } else {
                    int minSize = size - integers.size();
                    integers.add(num);
                    int count = 1;
                    while (i + 1 < nums.length && nums[i + 1] > num && nums[i + 1] < queue
                        .peekFirst()) {
                        i++;
                        integers.add(nums[i + 1]);
                        count++;
                    }
                    result += minSize * 2 + count;
                    while (!integers.isEmpty()) {
                        queue.addFirst(integers.poll());
                    }
                }


            }
        }
        return result;
    }
}
