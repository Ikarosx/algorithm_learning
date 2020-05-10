package 剑指offer.回溯法;

import org.junit.jupiter.api.Test;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author Ikaros
 * @date 2020/5/9 17:17
 */
public class 矩阵中的路径 {
    int[][] flags;
    // "ABCESFCSADEE",3,4,"ABCCED"
    
    @Test
    public void test() {
        char[] chars = "ABCESFCSADEE".toCharArray();
        System.out.println(hasPath(chars, 3, 4, "ABCD".toCharArray()));
    }
    
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] chars = new char[rows][cols];
        flags = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            chars[i / cols][i % cols] = matrix[i];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flags[i][j]++;
                if (chars[i][j] == str[0] && dfs(chars, i, j, str, 0)) {
                    return true;
                }
                flags[i][j]--;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] matrix, int rows, int cols, char[] str, int index) {
        if (index == str.length - 1) {
            return true;
        }
        // 向下
        if (rows + 1 < matrix.length && matrix[rows + 1][cols] == str[index + 1] && flags[rows + 1][cols] == 0) {
            flags[rows + 1][cols]++;
            if (dfs(matrix, rows + 1, cols, str, index + 1)) {
                return true;
            }
            flags[rows + 1][cols]--;
        }
        // 向上
        if (rows - 1 >= 0 && matrix[rows - 1][cols] == str[index + 1] && flags[rows - 1][cols] == 0) {
            flags[rows - 1][cols]++;
            if (dfs(matrix, rows - 1, cols, str, index + 1)) {
                return true;
            }
            flags[rows - 1][cols]--;
        }
        // 向左
        if (cols - 1 >= 0 && matrix[rows][cols - 1] == str[index + 1] && flags[rows][cols - 1] == 0) {
            flags[rows][cols - 1]++;
            if (dfs(matrix, rows, cols - 1, str, index + 1)) {
                return true;
            }
            flags[rows][cols - 1]--;
        }
        // 向右
        if (cols + 1 < matrix[0].length && matrix[rows][cols + 1] == str[index + 1] && flags[rows][cols + 1] == 0) {
            flags[rows][cols + 1]++;
            if (dfs(matrix, rows, cols + 1, str, index + 1)) {
                return true;
            }
            flags[rows][cols + 1]--;
        }
        return false;
    }
    
}
