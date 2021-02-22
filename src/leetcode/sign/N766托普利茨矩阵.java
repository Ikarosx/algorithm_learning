package leetcode.sign;

/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/02/22
 */
public class N766托普利茨矩阵 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!same(i, 0, matrix)) {
                return false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (!same(0, i, matrix)) {
                return false;
            }
        }
        return true;
    }

    private boolean same(int i, int j, int[][] matrix) {
        while (i + 1 < matrix.length && j + 1 < matrix[0].length) {
            if (matrix[i][j] != matrix[i + 1][j + 1]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
