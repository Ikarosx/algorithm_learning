package leetcode.序号.n500;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * <p>
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * <p>
 * 注意: 输入范围是&nbsp;[-1e7, 1e7] 。
 * <p>
 * 相关标签：
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/base-7/
 *
 * @author Ikarosx
 * @date 2021/7/8
 */
public class N504七进制数 {

    @Test
    public void test() {
        Assertions.assertEquals("202", convertToBase7(100));
        Assertions.assertEquals("-10", convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            num = -num;
            flag = true;
        }
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        StringBuilder reverse = sb.reverse();
        if (flag) {
            reverse.insert(0, '-');
        }
        return reverse.toString();
    }
}