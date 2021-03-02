package leetcode.sign;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * <p>
 * <p>
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/03/02
 */
public class N304二维区域和检索矩阵不可变 {
    private int[][] row;
    //private int[][] column;

    public N304二维区域和检索矩阵不可变(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        row = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                row[i][j + 1] = row[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 从(row1, col1)到(row2, col2)
        // 每一行计算
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += row[i][col2 + 1] - row[i][col1];
        }
        return result;
    }
}
