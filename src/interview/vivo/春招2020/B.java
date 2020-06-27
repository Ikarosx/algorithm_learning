package interview.vivo.春招2020;

import org.junit.jupiter.api.Test;

/**
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ...
 * ...）之乘积等于n，若不存在则输出 -1。
 *
 * @author Ikaros
 * @date 2020/6/4 11:32
 */
public class B {
    @Test
    public void test() {
        System.out.println(solution(100));
    }
    
    /**
     * 输入一个整形数值，返回一个整形值
     *
     * @param n
     *         int整型 n>9
     *
     * @return int整型
     */
    public int solution(int n) {
        int result = 1;
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            if (n <= 9) {
                builder.append(n);
                break;
            }
            boolean flag = false;
            for (int i = 9; i > 1; i--) {
                if (n % i == 0) {
                    builder.append(i);
                    n /= i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return -1;
            }
        }
        return Integer.valueOf(builder.reverse().toString());
    }
}
