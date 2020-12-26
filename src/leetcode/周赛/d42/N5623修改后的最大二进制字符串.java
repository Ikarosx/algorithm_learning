package leetcode.周赛.d42;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 *
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 * 示例 2：
 *
 * 输入：binary = "01"
 * 输出："01"
 * 解释："01" 没办法进行任何转换。
 *
 *
 * 提示：
 *
 * 1 <= binary.length <= 105
 * binary 仅包含 '0' 和 '1' 。
 *
 * @author Ikarosx
 * @date 2020/12/26 22:54
 */
public class N5623修改后的最大二进制字符串 {

    @Test
    public void test() {
        Assert.assertEquals("111011", maximumBinaryString("000110"));
        Assert.assertEquals("01", maximumBinaryString("01"));
        Assert.assertEquals("1", maximumBinaryString("1"));
        Assert.assertEquals("0", maximumBinaryString("0"));
        Assert.assertEquals("11111111110111111111", maximumBinaryString("01111001100000110010"));
    }

    public String maximumBinaryString(String binary) {
        int n = binary.length();
        int front = 0;
        while (front < n && binary.charAt(front) == '1') {
            front++;
        }
        if (front == n) {
            return binary;
        }
        int rest = 0;
        for (int i = front; i < n; i++) {
            if (binary.charAt(i) == '1') {
                rest++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("1");
        }
        stringBuilder.setCharAt(n - rest - 1, '0');
        return stringBuilder.toString();
    }

}
