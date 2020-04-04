package sort.question.数组中第N大元素;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;

/**
 * @author Ikaros
 * @date 2020/4/4 13:57
 */
public class NrdBigTest {
    @Test
    public void nrdBigTest() {
        int n = 10;
        Integer[] integers = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.printArray(integers);
        System.out.println(NrdBig.nrdBig(integers, 0, n - 1, 2));
    }
}
