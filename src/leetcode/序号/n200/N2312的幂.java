package leetcode.序号.n200;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例&nbsp;1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 2<sup>0</sup>&nbsp;= 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 2<sup>4</sup>&nbsp;= 16
 * <p>
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 * <p>
 * 相关标签：
 * 位运算
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/power-of-two/
 *
 * @author Ikarosx
 * @date 2021/4/27
 */
public class N2312的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        // x & -x 取出最右边的一个1
        // return (x & (-x)) == x;
		// x & x-1 将最右边的1置为0
        return (x & x- 1) == 0;
    }
}