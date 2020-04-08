package graph;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;

import java.util.Arrays;

/**
 * @author Ikaros
 * @date 2020/4/6 20:09
 */
public class LazyPrimMST {
    
    @Test
    public void minHeapTest() {
        MinHeap minHeap = new MinHeap(100);
        Integer[] integers = SortTestHelper.generateRandomArray(10, 1, 100);
        SortTestHelper.printArray(integers);
        for (Integer integer : integers) {
            minHeap.insert(integer);
        }
        System.out.println(Arrays.toString(minHeap.data));
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.extractMin());
        }
    }
    
    /**
     * 最小堆
     */
    class MinHeap {
        int count;
        int capacity;
        int[] data;
        
        MinHeap(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
            count = 0;
        }
        
        int size() {
            return count;
        }
        
        boolean isEmpty() {
            return count == 0;
        }
        
        void insert(int value) {
            assert count + 1 <= capacity;
            data[count] = value;
            shiftUp(count);
            count++;
        }
        
        private void shiftUp(int k) {
            int temp = data[k];
            while (k > 0 && data[(k - 1) / 2] > temp) {
                data[k] = data[(k - 1) / 2];
                k = (k - 1) / 2;
            }
            data[k] = temp;
        }
        
        int extractMin() {
            assert count > 0;
            int result = data[0];
            swap(0, --count);
            shiftDown(0);
            return result;
        }
        
        private void shiftDown(int i) {
            int temp = data[i];
            while (i * 2 + 1 < count) {
                int j = i * 2 + 1;
                // 取左右树中最小数
                if (j + 1 < count && data[j + 1] < data[j]) {
                    j++;
                }
                if (temp < data[j]) {
                    break;
                }
                data[i] = data[j];
                i = j;
            }
            data[i] = temp;
        }
        
        private void swap(int i, int i1) {
            int temp = data[i];
            data[i] = data[i1];
            data[i1] = temp;
        }
    }
}
