package leetcode.序号.n200;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于&nbsp;2 是一位数，所以返回 2。
 * <p>
 * 进阶:<br>
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * <p>
 * 相关标签：
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/add-digits/
 *
 * @author Ikarosx
 * @date 2021/5/4
 */
public class N258各位相加 {
    public int addDigits(int num) {
        // x*100+y*10+z=x*99+y*9+x+y+z
        return (num - 1) % 9 + 1;
    }
}