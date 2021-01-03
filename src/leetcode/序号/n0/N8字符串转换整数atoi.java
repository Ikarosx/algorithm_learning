package leetcode.序号.n0;

import org.junit.Assert;
import org.junit.Test;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * 通过次数237,067提交次数1,122,046
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/2 13:44
 */
public class N8字符串转换整数atoi {

    @Test
    public void test() {
        Assert.assertEquals(42, myAtoi("42"));
        Assert.assertEquals(-42, myAtoi("   -42"));
        Assert.assertEquals(4193, myAtoi("4193 with words"));
        Assert.assertEquals(0, myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
        Assert.assertEquals(-2147483648, myAtoi("-6147483648"));
    }

    public int myAtoi(String s) {
        boolean positive = true;
        int index = 0;
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char cc = s.charAt(0);
        if (cc != '+' && cc != '-' && (cc < '0' || cc > '9')) {
            return 0;
        }
        if (cc == '+' || cc == '-') {
            if (cc == '-') {
                positive = false;
            }
            index++;
        }
        StringBuilder builder = new StringBuilder();
        // index开始
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            builder.append(c);
        }
        int i = 1;
        int result = 0;
        // 去掉前导0
        while (builder.length() != 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        if (builder.length() == 0) {
            return 0;
        }
        int r = builder.length() - 1;
        while (r >= 0) {
            if (i > Integer.MAX_VALUE / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            int temp = i * (builder.charAt(r) - '0');
            if (temp + result < result) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result += temp;
            i *= 10;
            r--;
        }
        return positive ? result : -result;
    }
}
