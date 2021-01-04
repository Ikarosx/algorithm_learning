package leetcode.序号.n100;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/4 14:55
 */
public class N171Excel表列序号 {

    public int titleToNumber(String s) {
        int result = 0;
        int temp = 1;
        for (int length = s.length() - 1; length >= 0; length--) {
            char c = s.charAt(length);
            result += (c - 'A' + 1) * temp;
            temp *= 26;
        }
        return result;
    }
}
