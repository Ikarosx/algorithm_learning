package contest.超级码力在线编程大赛初赛1;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/8/29 10:13
 */
public class B正三角形拼接 {

    @Test
    public void test() {
        System.out.println(makeEquilateralTriangle(new int[]{2, 2, 2, 1}));
    }

    /**
     * @param lengths: the lengths of sticks at the beginning.
     *
     * @return: return the minimum number of cuts.
     */
    public int makeEquilateralTriangle(int[] lengths) {
        // write your code here.
        Arrays.sort(lengths);
        int pre = lengths[0];
        int maxValue = lengths[lengths.length - 1];
        int maxSame = 1;
        int temp = 1;
        // 3个1
        int minTime = maxValue / pre >= 2 ? 2 : 3;
        for (int i = 1; i < lengths.length; i++) {
            if (pre == lengths[i]) {
                temp++;
                if (i == lengths.length - 1) {
                    int need = 3 - temp;
                    minTime = need < minTime ? need : minTime;
                    if (minTime <= 0) {
                        return 0;
                    }
                }
            } else {
                int need = 3 - temp;
                int count = maxValue / pre;
                if (count < need) {
                    return minTime;
                }
                minTime = need < minTime ? need : minTime;
                if (minTime <= 0) {
                    return 0;
                }
                pre = lengths[i];
                temp = 1;
            }
        }
        return minTime;
    }
}
