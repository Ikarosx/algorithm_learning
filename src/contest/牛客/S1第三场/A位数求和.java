package contest.牛客.S1第三场;

import org.junit.jupiter.api.Test;

/**
 * @author Ikarosx
 * @date 2020/7/16 21:00
 */
public class A位数求和 {
    @Test
    public void test() {
        System.out.println(sum(6, 54));
    }
    
    /**
     * 返回这样的数之和
     *
     * @param n
     *         int整型 数的长度
     * @param m
     *         int整型 各个为之和
     *
     * @return long长整型
     */
    public long sum(int n, int m) {
        // write code here
        long result = 0;
        long start = (long) Math.pow(10, n - 1);
        long end = (long) Math.pow(10, n);
        for (long i = start; i < end; i++) {
            if (isEquals(i, m)) {
                result += i;
            }
        }
        return result;
    }
    
    private boolean isEquals(long start, int m) {
        String string = String.valueOf(start);
        for (int i = 0; i < string.length(); i++) {
            m -= string.charAt(i) - '1' + 1;
        }
        return m == 0;
    }
    
}
