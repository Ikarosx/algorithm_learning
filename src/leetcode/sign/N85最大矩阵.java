package leetcode.sign;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [['0']]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [['1']]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [['0','0']]
 * 输出：0
 *  
 *
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/26 20:36
 */
public class N85最大矩阵 {

    @Test
    public void test() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Assert.assertEquals(6, maximalRectangle(matrix));
        Assert.assertEquals(0, maximalRectangle(new char[][]{{'0'}}));
        Assert.assertEquals(0, maximalRectangle(new char[][]{{'0', '0'}}));
        Assert.assertEquals(1, maximalRectangle(new char[][]{{'1'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int i = matrix.length;
        int j = matrix[0].length;
        int[][] ints = new int[i][j];
        for (int ii = 0; ii < i; ii++) {
            for (int jj = 0; jj < j; jj++) {
                char c = matrix[ii][jj];
                if (c == '1') {
                    ints[ii][jj] = jj == 0 ? 0 : ints[ii][jj - 1] + 1;
                }
            }
        }
        int result = 0;
        for (int ii = 0; ii < i; ii++) {
            for (int jj = 0; jj < j; jj++) {
                // 宽度
                int width = ints[ii][jj];
                for (int up = ii; up >= 0; up--) {
                    // 高度
                    int height = ii - up + 1;
                    // 更新宽度
                    width = Math.min(width, ints[up][jj]);
                    if (width == 0) {
                        break;
                    }
                    // 更新矩阵大小
                    result = Math.max(result, height * width);
                }
            }
        }
        return result;
    }
}
