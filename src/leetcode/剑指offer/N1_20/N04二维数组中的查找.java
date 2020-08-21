package leetcode.剑指offer.N1_20;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/21 21:32
 */
public class N04二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 特判
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        // 从右上开始
        for (int row = 0, column = columnLength - 1; row < rowLength && column >= 0; ) {
            int current = matrix[row][column];
            if (target == current) {
                return true;
            } else if (target > current) {
                // 如果目标值大于当前值，往下
                row++;
            } else {
                // 如果目标值小于当前值，往左
                column--;
            }
        }
        return false;
    }
}
