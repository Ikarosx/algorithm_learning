package contest.top100CN;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/word-search/
 *
 * @author Ikaros
 * @date 2020/7/5 7:45
 */
public class N79单词搜索 {
    boolean[][] visit;
    
    @Test
    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABC"));
    }
    
    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) {
            return true;
        }
        int row = board.length;
        int column = board[0].length;
        visit = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visit[i][j] = true;
                    if (dfs(board, word, 1, i, j)) {
                        return true;
                    }
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int row, int column) {
        if (i == word.length()) {
            return true;
        }
        if (row > 0 && dfsHelper(board, word, i, row - 1, column)) {
            return true;
        }
        if (row < board.length - 1 && dfsHelper(board, word, i, row + 1, column)) {
            return true;
        }
        if (column > 0 && dfsHelper(board, word, i, row, column - 1)) {
            return true;
        }
        if (column < board[0].length - 1 && dfsHelper(board, word, i, row, column + 1)) {
            return true;
        }
        return false;
    }
    
    private boolean dfsHelper(char[][] board, String word, int i, int row, int column) {
        if (!visit[row][column] && board[row][column] == word.charAt(i)) {
            visit[row][column] = true;
            if (dfs(board, word, i + 1, row, column)) {
                return true;
            }
            visit[row][column] = false;
        }
        return false;
    }
}
