package contest.top100CN;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author Ikarosx
 * @date 2020/7/20 8:09
 */
public class N347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer integer : map.keySet()) {
            heap.add(integer);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] ints = new int[k];
        for (int i = 0; i < ints.length && !heap.isEmpty(); i++) {
            ints[i] = heap.poll();
        }
        return ints;
    }
}
