package heap;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Ikaros
 * @date 2020/4/4 19:29
 */
public class HeapTest {
    @Test
    public void maxHeapTest() {
        MaxHeap maxHeap = new MaxHeap(100);
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            maxHeap.insert(random.nextInt() % 20000);
        }
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
    }
}
