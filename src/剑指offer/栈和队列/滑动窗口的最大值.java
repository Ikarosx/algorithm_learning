package 剑指offer.栈和队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，
 * 找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author Ikaros
 * @date 2020/5/9 16:50
 */
public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        if (size > num.length || size == 0 || num.length == 0) {
            return result;
        }
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
            
        }
        result.add(heap.peek());
        int l = 0;
        int r = size - 1;
        while (r < num.length - 1) {
            heap.remove(num[l++]);
            heap.add(num[++r]);
            result.add(heap.peek());
        }
        return result;
    }
}
