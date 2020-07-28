package contest.top100CN;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author Ikarosx
 * @date 2020/7/28 18:03
 */
public class N48旋转图像 {
    public void rotate(int[][] matrix) {
        // 先转置后反转每一行
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
