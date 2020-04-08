package sort.onlogn;

import heap.MaxHeap;

/**
 * @author Ikaros
 * @date 2020/4/4 19:43
 */
public class HeapSort {
    public static void sort(Comparable[] array, Integer l, Integer r) {
        // heapify
        for (int i = r / 2; i >= l; i--) {
            shiftDown(array, l, r, i);
        }
        for (int i = r; i > l; i--) {
            swap(array, i, l);
            shiftDown(array, l, i - 1, l);
        }
    }
    
    private static void swap(Comparable[] array, Integer i, Integer j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void shiftDown(Comparable[] array, Integer l, Integer r, int i) {
        while (2 * i + 1 <= r) {
            int j = 2 * i + 1;
            while (j + 1 <= r && array[j].compareTo(array[j + 1]) <= 0) {
                j += 1;
            }
            if (array[j].compareTo(array[i]) <= 0) {
                break;
            }
            swap(array, i, j);
            i = j;
        }
    }
    
    public static void sort1(Comparable[] array, Integer l, Integer r) {
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
