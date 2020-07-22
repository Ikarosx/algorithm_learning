package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author Ikarosx
 * @date 2020/7/21 9:49
 */
public class N461汉明距离 {
    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
    }
    
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int result = 0;
        while (i != 0) {
            result++;
            i &= i - 1;
        }
        return result;
    }
}
