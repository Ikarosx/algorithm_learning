package 剑指offer.发散思维能力;

import org.junit.jupiter.api.Test;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、
 * if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @author Ikaros
 * @date 2020/5/7 11:16
 */
public class 求1加到n {
    @Test
    public void test() {
        System.out.println(Sum_Solution(1000));
    }
    
    
    int[] mask = {0x00000000, 0xFFFFFFFF};
    
    public int Sum_Solution(int n) {
        return production(n + 1, n) >> 1;
    }
    
    int production(int m, int n) {
        int result = 0;
        boolean isStop = (m != 0) && (result = (n & mask[m & 1]) + production(m >> 1, n << 1)) != 0;
        return result;
    }
}