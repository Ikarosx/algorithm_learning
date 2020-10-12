package interview.字节跳动.笔试20201011;

/**
 * @author Ikarosx
 * @date 2020/10/11 12:35
 */
public class 铺瓷砖 {

    static int result = 0;

    public int cutCake(int a, int b) {
        // TODO
        int result = 0;
        int[][] dp = new int[a][b];
        dfs(dp, 0, 0, a - 1, b - 1);

        return result;
    }

    private void dfs(int[][] dp, int x, int y, int a, int b) {
        // 修正坐标
        if (y > b) {
            y = 0;
            x++;
        }
        if (x == a && y == b && dp[x][y] == 1) {
            result++;
            return;
        }
        // 横放
        if (y + 1 > b){
            dp[x][y] = 1;
            dp[x][y + 1] = 1;
            dfs(dp, x, y + 2, a, b);
            dp[x][y] = 0;
            dp[x][y + 1] = 0;
        }
    }
}
