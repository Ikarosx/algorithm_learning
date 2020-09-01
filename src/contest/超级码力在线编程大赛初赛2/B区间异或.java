package contest.超级码力在线编程大赛初赛2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/8/30 10:00
 */
public class B区间异或 {

    @Test
    public void test() {
        Assert.assertEquals(3, Intervalxor(new int[]{1, 2, 3, 4, 5}, new LinkedList<List<Integer>>() {{
            add(Arrays.asList(1, 2, 3, 4));
            add(Arrays.asList(1, 2, 4, 5));
        }}));
    }

    public int Intervalxor(int[] num, List<List<Integer>> ask) {
        // write your code here
        int[] ints = new int[ask.size()];
        for (int i = 0; i < ask.size(); i++) {
            List<Integer> integers = ask.get(i);
            int l1 = integers.get(0) - 1;
            int r1 = integers.get(1) - 1;
            int l2 = integers.get(2) - 1;
            int r2 = integers.get(3) - 1;
            int max = num[l1];
            int min = num[l2];
            for (int j = l1; j <= r1; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            for (int j = l2; j <= r2; j++) {
                if (num[j] < min) {
                    min = num[j];
                }
            }
            ints[i] = min + max;
        }
        int result = ints[0];
        for (int i = 1; i < ints.length; i++) {
            result ^= ints[i];
        }
        return result;
    }
}
