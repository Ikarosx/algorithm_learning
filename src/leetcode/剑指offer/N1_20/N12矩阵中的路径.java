package leetcode.剑指offer.N1_20;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 8:02
 */
public class N12矩阵中的路径 {

    int[][] position = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(word, 0, i, j, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯法
     *
     * @param word 字符串
     * @param index 当前要判断的字符串的下标
     * @param row 现在在数组中的横坐标
     * @param column 现在在数组中的纵坐标
     * @param board char数组
     */
    private boolean dfs(String word, int index, int row, int column, char[][] board) {
        if (row == -1 || column == -1 || row == board.length || column == board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[row][column]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[row][column];
        // --------------- 优化-不需要数组，标记为/ ---------------
        board[row][column] = '/';
        for (int[] ints : position) {
            if (dfs(word, index + 1, row + ints[0], column + ints[1], board)) {
                return true;
            }
        }
        board[row][column] = temp;
        return false;
    }


}
