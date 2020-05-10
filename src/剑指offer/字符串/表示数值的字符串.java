package 剑指offer.字符串;

import org.junit.jupiter.api.Test;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author Ikaros
 * @date 2020/5/8 17:52
 */
public class 表示数值的字符串 {
    @Test
    public void test() {
        System.out.println(isNumeric("1.2.3".toCharArray()));
    }
    
    public boolean isNumeric(char[] str) {
        return isNumericImpl(str, false, false, 0);
    }
    
    private boolean isNumericImpl(char[] str, boolean e, boolean spot, int i) {
        if (i >= str.length) {
            char c = str[i - 1];
            return c != '+' && c != '-' && c != 'e' && c != 'E' && c != '.';
        }
        char c = str[i];
        if (c == '+' || c == '-') {
            if (i == 0 || str[i - 1] == 'e' || str[i - 1] == 'E') {
                return isNumericImpl(str, e, spot, i + 1);
            }
            return false;
        } else if (!e && (c == 'e' || c == 'E')) {
            return isNumericImpl(str, true, spot, i + 1);
        } else if (!spot && c == '.' && !e) {
            return isNumericImpl(str, e, true, i + 1);
        } else if (c >= '0' && c <= '9') {
            return isNumericImpl(str, e, spot, i + 1);
        }
        return false;
    }
    
    
}
