package 剑指offer.回溯法;

import org.junit.jupiter.api.Test;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author Ikaros
 * @date 2020/5/9 17:50
 */
public class 机器人的运动范围 {
    @Test
    public void test() {
        System.out.println(movingCount(15, 20, 20));
    }
    
    int[][] visit;
    
    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0 || threshold < 0) {
            return 0;
        }
        visit = new int[rows][cols];
        visit[0][0] = 1;
        movingCountImpl(threshold, rows, cols, 0, 0);
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result += visit[i][j];
            }
        }
        return result;
    }
    
    private void movingCountImpl(int threshold, int rows, int cols, int crows, int ccols) {
        // 向下
        if (crows + 1 < rows && calcNum(crows + 1, ccols) <= threshold && visit[crows + 1][ccols] == 0) {
            visit[crows + 1][ccols]++;
            movingCountImpl(threshold, rows, cols, crows + 1, ccols);
        }
        // 上
        if (crows - 1 >= 0 && calcNum(crows - 1, ccols) <= threshold && visit[crows - 1][ccols] == 0) {
            visit[crows - 1][ccols]++;
            movingCountImpl(threshold, rows, cols, crows - 1, ccols);
        }
        // 左
        if (ccols - 1 >= 0 && calcNum(crows, ccols - 1) <= threshold && visit[crows][ccols - 1] == 0) {
            visit[crows][ccols - 1]++;
            movingCountImpl(threshold, rows, cols, crows, ccols - 1);
        }
        // 右
        if (ccols + 1 < cols && calcNum(crows, ccols + 1) <= threshold && visit[crows][ccols + 1] == 0) {
            visit[crows][ccols + 1]++;
            movingCountImpl(threshold, rows, cols, crows, ccols + 1);
        }
    }
    
    private int calcNum(int i, int j) {
        int result = 0;
        while (i != 0) {
            result += i % 10;
            i /= 10;
        }
        while (j != 0) {
            result += j % 10;
            j /= 10;
        }
        return result;
    }
}
