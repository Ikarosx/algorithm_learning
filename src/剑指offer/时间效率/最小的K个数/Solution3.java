package 剑指offer.时间效率.最小的K个数;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;

import java.util.ArrayList;


/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路②最大堆
 *
 * @author Ikaros
 * @date 2020/04/05 11:53
 */
public class Solution3 {
    public ArrayList<Integer> GetLeastNumbers_Solution(Integer[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k) {
            return list;
        }
        MinHeap MinHeap = new MinHeap(100);
        for (Integer integer : input) {
            MinHeap.insert(integer);
        }
        for (int i = 0; i < k; i++) {
            list.add(MinHeap.extractMax());
        }
        return list;
    }
    
    
    private void swap(Integer[] input, int l, int i) {
        int temp = input[l];
        input[l] = input[i];
        input[i] = temp;
    }
    
    
    @Test
    public void solutionTest() {
        int n = 10;
        Integer[] integers = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] test = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(test, 4));
    }
    
    class MinHeap {
        int count;
        Integer[] data;
        int capacity;
        
        private MinHeap() {
        
        }
        
        MinHeap(int capacity) {
            data = new Integer[capacity + 1];
            this.capacity = capacity;
        }
        
        void insert(int k) {
            assert ++count <= capacity;
            data[count] = k;
            shiftUp(count);
        }
        
        int extractMax() {
            int result = data[1];
            swap(data, 1, count--);
            shiftDown(1);
            return result;
        }
        
        private void shiftDown(int i) {
            int temp = data[i];
            while (i * 2 <= count) {
                int j = 2 * i;
                if (j + 1 <= count && data[j] > data[j + 1]) {
                    j += 1;
                }
                // 比最小的那个还要小，说明已经满足最小堆
                if (temp <= data[j]) {
                    break;
                }
                data[i] = data[j];
                i = j;
            }
            data[i] = temp;
        }
        
        boolean isEmpty() {
            return count == 0;
        }
        
        private void shiftUp(int k) {
            int temp = data[k];
            while (k > 1 && data[k / 2] > temp) {
                data[k] = data[k / 2];
                k /= 2;
            }
            data[k] = temp;
        }
        
        MinHeap(int[] array) {
            data = new Integer[array.length + 1];
            count = array.length;
            for (int i = 0; i < array.length; i++) {
                data[i + 1] = array[i];
            }
            // 最后一个非叶子结点
            int k = count / 2;
            while (k > 0) {
                shiftDown(k--);
            }
        }
    }
}