package interview.vivo.春招2020;

import org.junit.jupiter.api.Test;

/**
 * 现有一个 3x3 规格的 Android 智能手机锁屏程序和两个正整数 m 和 n ，请计算出使用最少m
 * 个键和最多 n个键可以解锁该屏幕的所有有效模式总数。
 * 其中有效模式是指：
 * 1、每个模式必须连接至少m个键和最多n个键；
 * 2、所有的键都必须是不同的；
 * 3、如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择，不允许跳过非选择键（如图）；
 * 4、顺序相关，单键有效（这里可能跟部分手机不同）。
 * <p>
 * 输入：m,n
 * 代表允许解锁的最少m个键和最多n个键
 * 输出：
 * 满足m和n个键数的所有有效模式的总数
 *
 * @author Ikaros
 * @date 2020/6/4 11:17
 */
public class A {
    
    int[][] visited = new int[4][4];
    //16个方向
    int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    int[] times = new int[10];
    
    boolean canVisited(int i, int j) {
        if (i < 1 || i > 3 || j < 1 || j > 3 || visited[i][j] == 1) {
            return false;
        }
        return true;
    }
    
    void dfs(int i, int j, int n) {
        if (n == 9) {
            return;
        }
        visited[i][j]++;
        times[n++]++;
        for (int k = 0; k < dir.length; k++) {
            int ii = i + dir[k][0];
            int jj = j + dir[k][1];
            if (canVisited(ii, jj)) {
                dfs(ii, jj, n);
            } else if (k < 8) {
                ii += dir[k][0];
                jj += dir[k][1];
                // 该点未被选择
                if (canVisited(ii, jj)) {
                    dfs(ii, jj, n);
                }
            }
        }
        visited[i][j]--;
    }
    
    public int solution(int m, int n) {
        // 易被忽略
        if (m > n) {
            return 0;
        }
        // 参数检查必须有
        m = (m < 0 ? 0 : m);
        n = (n > 9 ? 9 : n);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                dfs(i, j, 1);
            }
        }
        int ans = 0;
        for (int i = m; i <= n; i++) {
            ans += times[i];
        }
        return ans;
    }
    
    @Test
    public void test() {
        System.out.println(solution(1, 2));
    }
}

