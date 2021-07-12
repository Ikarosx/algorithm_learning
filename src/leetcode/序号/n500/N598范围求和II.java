package leetcode.序号.n500;

/**
 * 给定一个初始元素全部为&nbsp;0，大小为 m*n 的矩阵&nbsp;M&nbsp;以及在&nbsp;M&nbsp;上的一系列更新操作。
 * <p>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数&nbsp;a 和 b 的数组表示，含义是将所有符合&nbsp;0 <= i < a 以及 0 <= j < b 的元素&nbsp;M[i][j]&nbsp;的值都增加 1。
 * <p>
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * 输出: 4
 * 解释:
 * 初始状态, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [2,2] 后, M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [3,3] 后, M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * <p>
 * 注意:
 *
 * <ol>
 * m 和 n 的范围是&nbsp;[1,40000]。
 * a 的范围是 [1,m]，b 的范围是 [1,n]。
 * 操作数目不超过 10000。
 * </ol>
 * <p>
 * 相关标签：
 * 数组
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/range-addition-ii/
 *
 * @author Ikarosx
 * @date 2021/7/12
 */
public class N598范围求和II {
    public int maxCount(int m, int n, int[][] ops) {
    	// 求交集范围
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}