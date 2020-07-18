package contest.top100CN;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author Ikarosx
 * @date 2020/7/18 7:27
 */
public class N240搜索二维矩阵II {
    @Test
    public void test() {
        int[][] ints = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(ints, target));
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从左下或者右上思考
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 二分法
        // 每次找到二维数组中的中点
        // 如果相等，返回true
        // 如果小于中点，说明不可能在右下角
        // 如果大于中点，说明不可能在左上角
        return searchMatrixImply(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, target);
    }
    
    private boolean searchMatrixImply(int[][] matrix, int columnStart, int columnEnd, int rowStart, int rowEnd, int target) {
        if (columnStart < 0 || rowStart < 0 || columnStart > columnEnd || rowStart > rowEnd) {
            return false;
        }
        int columnMid = (columnEnd - columnStart) / 2 + columnStart;
        int rowMid = (rowEnd - rowStart) / 2 + rowStart;
        int value = matrix[rowMid][columnMid];
        if (value > target) {
            // 如果目标值小于中点，说明不可能在右下角
            // 切割为左下角
            // 如果左下角部分的第一个>target，那么不需要判断左下角
            if (matrix[rowMid][columnStart] <= target && searchMatrixImply(matrix, columnStart, columnMid - 1, rowMid, rowEnd, target)) {
                return true;
            }
            // 上面部分
            while (rowMid > rowStart && matrix[rowMid - 1][columnStart] > target) {
                rowMid--;
            }
            if (searchMatrixImply(matrix, columnStart, columnEnd, rowStart, rowMid - 1, target)) {
                return true;
            }
        } else if (value < target) {
            // 如果目标值大于中点，说明不可能在左上角
            // 切割为右上角、下面部分
            // 右上角
            // 如果目标值大于右上角部分的最大值就不取右上角
            if (target <= matrix[rowMid][columnEnd] && searchMatrixImply(matrix, columnMid + 1, columnEnd, rowStart, rowMid, target)) {
                return true;
            }
            // 取下面部分
            while (rowMid < rowEnd && matrix[rowMid + 1][columnEnd] < target) {
                rowMid++;
            }
            if (searchMatrixImply(matrix, columnStart, columnEnd, rowMid + 1, rowEnd, target)) {
                return true;
            }
        } else {
            // ==
            return true;
        }
        return false;
    }
}
