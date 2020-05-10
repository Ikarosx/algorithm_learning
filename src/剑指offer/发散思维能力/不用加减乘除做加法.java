package 剑指offer.发散思维能力;

import org.junit.jupiter.api.Test;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author Ikaros
 * @date 2020/5/7 12:52
 */
public class 不用加减乘除做加法 {
    @Test
    public void test() {
        System.out.println(Add(-1, 2));
    }
    
    public int Add(int num1, int num2) {
        int result, ans;
        do {
            result = num1 ^ num2; // 相加
            ans = (num1 & num2) << 1;// 进位
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }
    
    
}
