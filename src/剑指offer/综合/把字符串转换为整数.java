package 剑指offer.综合;

import org.junit.jupiter.api.Test;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * @author Ikaros
 * @date 2020/5/7 17:02
 */
public class 把字符串转换为整数 {
    @Test
    public void test() {
        int i = StrToInt("-2147483649");
        System.out.println(i);
    }
    
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char c = str.charAt(0);
        boolean positive = true;
        if (c == '-') {
            positive = false;
            str = str.substring(1);
        } else if (c == '+') {
            str = str.substring(1);
        }
        int j = 1;
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c1 = str.charAt(i);
            if (c1 >= '0' && c1 <= '9') {
                result += j * (c1 - '0');
                j *= 10;
            } else {
                return 0;
            }
        }
        return positive ? result : -result;
    }
}
