package leetcode.序号.n100;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * <p>
 * 示例&nbsp;2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 示例&nbsp;3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * <p>
 * 相关标签：
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/excel-sheet-column-title/
 *
 * @author Ikarosx
 * @date 2021/4/26
 */
public class N168Excel表列名称 {
    @Test
    public void test() {
        Assert.assertEquals("A", convertToTitle(1));
        Assert.assertEquals("AB", convertToTitle(28));
        Assert.assertEquals("ZY", convertToTitle(701));
    }

    /**
     * 本质上是进制转换
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            sb.insert(0, (char) ((columnNumber - 1) % 26 + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.toString();
    }
}