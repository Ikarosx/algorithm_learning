package leetcode.sign;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 * 通过次数23,055提交次数51,328
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/4 15:50
 */
public class N480滑动窗口中位数 {
    // 大根堆
    private PriorityQueue<Integer> lp = new PriorityQueue<>(Comparator.reverseOrder());
    // 小根堆
    private PriorityQueue<Integer> rp = new PriorityQueue<>();

    Map<Integer, Integer> delayed = new HashMap<>();

    private int k;
    // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
    private int smallSize, largeSize;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
        double[] result = new double[n];
        int l = 0;
        int r = k - 1;

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        result[0] = getMedian();
        for (int i = k; i < nums.length; i++) {
            addNum(nums[i]);
            earse(nums[i - k]);
            result[i - k + 1] = getMedian();
        }

        return result;
    }

    private void earse(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= lp.peek()) {
            --smallSize;
            if (num == lp.peek()) {
                prune(lp);
            }
        } else {
            --largeSize;
            if (num == rp.peek()) {
                prune(rp);
            }
        }
        balance();
    }

    private double getMedian() {
        double result;
        if ((k & 1) == 1) {
            result = lp.peek();
        } else {
            result = (0.0 + rp.peek() + lp.peek()) / 2.0;
        }
        return result;
    }


    public void addNum(int num) {
        if (lp.isEmpty() || num <= lp.peek()) {
            lp.add(num);
            smallSize++;
        } else {
            rp.add(num);
            largeSize++;
        }
        balance();
    }

    private void balance() {
        if (smallSize > largeSize + 1) {
            rp.add(lp.poll());
            smallSize--;
            largeSize++;
            // small 堆顶元素被移除，需要进行 prune
            prune(lp);
        } else if (smallSize < largeSize) {
            lp.add(rp.poll());
            largeSize--;
            smallSize++;
            // large 堆顶元素被移除，需要进行 prune
            prune(rp);
        }
    }

    // 不断地弹出 heap 的堆顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }


    public double findMedian() {
        if (lp.size() > rp.size()) {
            return lp.peek();
        } else {
            return (lp.peek() + rp.peek()) / 2.0;
        }
    }
}
