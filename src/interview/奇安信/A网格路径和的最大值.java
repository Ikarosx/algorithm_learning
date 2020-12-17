package interview.奇安信;

/**
 * @author Ikarosx
 * @date 2020/10/18 14:54
 */
public class A网格路径和的最大值 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型
     */
    public int maxValue (int[][] matrix) {
        // write code here
        for (int i = 1; i < matrix[0].length; i++) {
            // 先处理第一行
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            // 先处理第一列
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // 上边和左边取最大值，加上自己本身
                matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
