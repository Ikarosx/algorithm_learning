package contest.牛客.S1第三场;

import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/7/16 21:46
 */
public class B不可思议 {
    @Test
    public void test() {
        work(3, 1, 1, 1, 1);
    }
    
    /**
     * @param n
     *         int整型
     * @param seed1
     *         long长整型
     * @param seed2
     *         long长整型
     * @param seed3
     *         long长整型
     * @param x
     *         int整型
     *
     * @return long长整型
     */
    public long work(int n, long seed1, long seed2, long seed3, int x) {
        // write code here
        long[] u = new long[n];
        long[] v = new long[n];
        long seed4;
        for (int i = 1; i < n; i++) {
            seed4 = (seed1 + seed2) % 998244353 * seed3 % 998244353;
            u[i] = i + 1;
            v[i] = (seed4 % i) + 1;
            seed3 = seed2;
            seed2 = seed1;
            seed1 = seed4;
        }
        int lastans = 0;
        int ret = 0;
        int y = 0;
        int z;
        for (int i = 1; i <= n; i++) {
            z = ans(x, y);
            ret = (ret + z) % 998244353;
            lastans = z;
            x = ((x + lastans) ^ ret) % n + 1;
            y = lastans;
        }
        return ret;
    }
    
    private int ans(int x, int y) {
        // 令x小数
        if (y < x) {
            int temp = x;
            x = y;
            y = temp;
        }
        
        return 0;
    }
}
