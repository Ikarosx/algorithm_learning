package sort.onlogn;

import heap.MaxHeap;

/**
 * @author Ikaros
 * @date 2020/4/4 19:43
 */
public class HeapSort {
    public static void sort(Comparable[] array, Integer l, Integer r) {
        MaxHeap maxHeap = new MaxHeap(r - l + 1);
        for (Comparable comparable : array) {
            maxHeap.insert(comparable);
        }
        for (int i = r; i >= l; i--) {
            Comparable comparable = maxHeap.extractMax();
            array[i] = comparable;
        }
    }
    
    public static void heapify(Comparable[] array, Integer l, Integer r) {
        MaxHeap maxHeap = new MaxHeap(array);
        for (int i = r; i >= l; i--) {
            Comparable comparable = maxHeap.extractMax();
            array[i] = comparable;
        }
    }
}
