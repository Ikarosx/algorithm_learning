package heap;

/**
 * @author Ikaros
 * @date 2020/4/4 18:53
 */
public class MaxHeap {
    private Comparable[] data;
    private int count;
    private int capacity;
    
    MaxHeap(int capacity) {
        data = new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public void insert(Comparable item) {
        assert ++count <= capacity;
        data[count] = item;
        shiftUp(count);
    }
    
    public Comparable extractMax() {
        assert count > 0;
        Comparable result = data[1];
        swap(1, count--);
        shiftDown(1);
        return result;
    }
    
    private void shiftDown(int k) {
        while (2 * k <= count) {
            // data[k]应该和data[j]交换位置
            int j = 2 * k;
            if (j + 1 <= count && data[j].compareTo(data[j + 1]) < 0) {
                j += 1;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
    
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k / 2, k);
            k /= 2;
        }
    }
    
    private void swap(int i, int k) {
        Comparable temp = data[i];
        data[i] = data[k];
        data[k] = temp;
    }
}
