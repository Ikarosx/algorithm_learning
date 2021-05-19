package leetcode.序号.n1700;

import java.util.Arrays;

/**
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为&nbsp;m x n 由非负整数组成。
 * <p>
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * <p>
 * 请你找出&nbsp;matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * <p>
 * 示例 3：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * <p>
 * 示例 4：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 10<sup>6</sup>
 * 1 <= k <= m * n
 * <p>
 * <p>
 * 相关标签：
 * 数组
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 *
 * @author Ikarosx
 * @date 2021/5/19
 */
public class N1738找出第K大的异或坐标值 {
    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        // 存放结果便于排序
        int[] ints = new int[row * column];
        int i = 0;
        // 异或数组
        int[][] xorArray = new int[row][column];
        for (int j = 0; j < row; j++) {
            for (int l = 0; l < column; l++) {
            	// 当前异或值 = 左边 ^ 上边 ^ 左上
                int result = matrix[j][l];
                result ^= j > 0 ? xorArray[j - 1][l] : 0;
                result ^= l > 0 ? xorArray[j][l - 1] : 0;
                result ^= l > 0 && j > 0 ? xorArray[j - 1][l - 1] : 0;
                xorArray[j][l] = result;
                ints[i++] = result;
            }
        }
        // 排序
		Arrays.sort(ints);
		return ints[ints.length - k];
    }
}