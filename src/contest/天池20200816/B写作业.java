package contest.天池20200816;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/8/16 10:30
 */
public class B写作业 {

    @Test
    public void test() {
        System.out.println(doingHomework(new int[]{1, 2, 3, 5}, new int[]{6, 10, 4}));
    }

    /**
     * @param cost: the cost
     * @param val: the value
     *
     * @return: the all cost
     */
    public long doingHomework(int[] cost, int[] val) {
        Arrays.sort(val);
        long temp = 0;
        int valI = 0;
        long result = 0;
        for (int i = 0; i < val.length; i++) {
            // 如果当前加上这个也可以
            while (valI < cost.length && temp + cost[valI] <= val[i]) {
                temp += cost[valI];
                valI++;
            }
            result += temp;
        }
        return result;
    }
}
