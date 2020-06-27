package interview.拼多多.校招2020;

import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/6/6 14:16
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            MinHeap minHeap = new MinHeap(k);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    minHeap.add(i * j);
                }
            }
            System.out.println(minHeap.pop());
        }
        scanner.close();
        
    }
    
    static class MinHeap {
        int[] data;
        int capacity;
        int size;
        
        boolean isEmpty() {
            return size == 0;
        }
        
        MinHeap(int capacity) {
            this.capacity = capacity;
            data = new int[capacity + 1];
            size = 0;
        }
        
        public int pop() {
            int result = data[1];
            data[1] = data[size--];
            shiftdown(1);
            return result;
        }
        
        void add(int k) {
            if (size < capacity) {
                data[++size] = k;
                shiftup(size);
            } else if (data[1] < k) {
                data[1] = k;
                shiftdown(1);
            }
        }
        
        private void shiftup(int n) {
            int tempN = data[n];
            while ((n / 2) >= 1 && data[n / 2] > tempN) {
                data[n] = data[n / 2];
                n /= 2;
            }
            data[n] = tempN;
        }
        
        private void shiftdown(int i) {
            int tempI = data[i];
            while (i * 2 <= capacity) {
                int temp = i * 2;
                if (temp + 1 <= capacity && data[i * 2 + 1] < data[i * 2]) {
                    temp++;
                }
                if (data[temp] < tempI) {
                    data[i] = data[temp];
                    i = temp;
                } else {
                    break;
                }
            }
            data[i] = tempI;
        }
    }
}
