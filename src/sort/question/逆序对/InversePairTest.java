package sort.question.逆序对;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;

/**
 * @author Ikaros
 * @date 2020/4/4 12:11
 */
public class InversePairTest {
    @Test
    public void inversePairTest() {
        int n = 10;
        Integer[] integers = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.printArray(integers);
        System.out.println(InversePair.countInversePair(integers, 0, n - 1));
    }
}