package heap;

/**
 * @author Ikaros
 * @date 2020/4/4 18:53
 */
public class MaxHeap {
    private Comparable[] data;
    private int count;
    private int capacity;
    
    public MaxHeap(int capacity) {
        data = new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }
    public MaxHeap(Comparable[] array) {
        data = new Comparable[array.length + 1];
        count = array.length;
        capacity = array.length;
        for (int i = 0; i < count; i++) {
            data[1 + i] = array[i];
        }
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public void insert(Comparable item) {
        // 扩容 TODO
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
        // 优化，不交换
        Comparable temp = data[k];
        while (2 * k <= count) {
            // data[k]应该和data[j]交换位置
            int j = 2 * k;
            if (j + 1 <= count && data[j].compareTo(data[j + 1]) < 0) {
                j += 1;
            }
            if (temp.compareTo(data[j]) >= 0) {
                break;
            }
            data[k] = data[j];
            k = j;
        }
        data[k] = temp;
    }
    
    private void shiftUp(int k) {
        // 优化，不交换，直接赋值
        Comparable temp = data[k];
        while (k > 1 && data[k / 2].compareTo(temp) < 0) {
            data[k] = data[k / 2];
            k /= 2;
        }
        data[k] = temp;
    }
    
    private void swap(int i, int k) {
        Comparable temp = data[i];
        data[i] = data[k];
        data[k] = temp;
    }
}
