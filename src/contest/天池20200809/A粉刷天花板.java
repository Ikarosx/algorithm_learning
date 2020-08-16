package contest.天池20200809;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/8/9 10:09
 */
public class A粉刷天花板 {

    @Test
    public void solution() {
        System.out.println(painttheCeiling(2, 1000000, 1000000000, 3, 1000000000, 500));
    }


    /**
     * @param s0: the number s[0]
     * @param n: the number n
     * @param k: the number k
     * @param b: the number b
     * @param m: the number m
     * @param a: area
     *
     * @return: the way can paint the ceiling
     */
    public long painttheCeiling(int s0, int n, int k, int b, int m, long a) {
        long[] longs = new long[n];
        longs[0] = s0;
        // 生成集合
        for (int i = 1; i < n; i++) {
            longs[i] = (k * longs[i - 1] + b) % m + 1 + longs[i - 1];
        }
        Arrays.sort(longs);
        long result = 0;
        // 判断左右乘是否满足，不满足右一直缩，当满足时结果加上r - l
        // 至少要两个数，所以要小于n - 1
        for (int i = 0; i < n - 1; i++) {
            long ilong = longs[i];
            // 自乘
            if (ilong * ilong < ilong) {
                System.out.println("溢出");
            }
            if (ilong * ilong <= a) {
                result++;
            }
            //            for (int j = n - 1; j > i; j--) {
            //                if (longs[j] * ilong <= a) {
            //                    // 颠倒顺序也成立，即颠倒宽高
            //                    result += (j - i) * 2;
            //                    break;
            //                }
            //            }
        }
        return result;
    }

}
