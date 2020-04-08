package heap;

/**
 * reverse 待写 TODO
 * @author Ikaros
 * @date 2020/4/4 18:53
 */
public class IndexMaxHeap {
    private Comparable[] data;
    private Integer[] indexes;
    /**
     * reverse[i]表示i索引在堆中的位置
     */
    private Integer[] reverse;
    private int count;
    private int capacity;
    
    public IndexMaxHeap(int capacity) {
        data = new Comparable[capacity + 1];
        indexes = new Integer[capacity + 1];
        reverse = new Integer[capacity + 1];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * @param i
     *         传入的i对用户而言是从0开始索引的
     * @param item
     */
    public void insert(int i, Comparable item) {
        
        // 扩容 TODO
        assert count + 1 <= capacity;
        assert i >= 0 && i + 1 <= capacity;
        data[++i] = item;
        indexes[++count] = i;
        reverse[i] = count;
        shiftUp(count);
    }
    
    public Comparable extractMax() {
        assert count > 0;
        Comparable result = data[indexes[1]];
        swap(indexes[1], indexes[count]);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return result;
    }
    
    public int extractIndexMax() {
        assert count > 0;
        int result = indexes[1] - 1;
        swap(indexes[1], indexes[count]);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return result;
    }
    
    Comparable getValue(int i) {
        return data[i + 1];
    }
    
    void change(int i, Comparable newValue) {
        i++;
        data[i] = newValue;
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftDown(j);
                shiftUp(j);
                return;
            }
        }
        
    }
    
    private void shiftDown(int k) {
        // 优化，不交换
        Integer temp = indexes[k];
        while (2 * k <= count) {
            // data[k]应该和data[j]交换位置
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) < 0) {
                j += 1;
            }
            if (data[temp].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            indexes[k] = indexes[j];
            k = j;
        }
        indexes[k] = temp;
    }
    
    private void shiftUp(int k) {
        // 优化，不交换，直接赋值
        Integer temp = indexes[k];
        while (k > 1 && data[indexes[k / 2]].compareTo(data[temp]) < 0) {
            indexes[k] = indexes[k / 2];
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
        indexes[k] = temp;
    }
    
    private void swap(int i, int k) {
        Comparable temp = data[i];
        data[i] = data[k];
        data[k] = temp;
    }
}
