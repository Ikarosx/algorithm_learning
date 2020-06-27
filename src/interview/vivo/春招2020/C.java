package interview.vivo.春招2020;

import org.junit.jupiter.api.Test;

/**
 * 在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
 * 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ...
 * ...
 * 以此类推，请编程计算出第n天总共可以量产的手机数量。
 *
 * @author Ikaros
 * @date 2020/6/4 12:23
 */
public class C {
    @Test
    public void test() {
        System.out.println(solution(5));
    }
    
    /**
     * @param n
     *         int整型 第n天
     *
     * @return int整型
     */
    public int solution(int n) {
        int i = 0;
        int result = 0;
        int sum = 0;
        for (; ; ) {
            result += ++i;
            sum += i * i;
            if (n <= result) {
                return sum - (result - n) * i;
            }
        }
    }
}
