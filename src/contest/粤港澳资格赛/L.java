package collection.粤港澳资格赛;

import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/25 18:15
 */
public class L {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            // 0颜值 1价值
            int[][] array = new int[n][2];
            for (int j = 0; j < array.length; j++) {
                int a = scanner.nextInt();
                array[j][1] = a / 10000;
                array[j][0] = a % 10000;
            }
            // 状态转移方程
            // dp2[j][0] 为 捕获第j条鱼时的最大收益
            // dp2[j][1] 为 不捕获第j条鱼时的最大收益
            // 从左向右
            int[][] dp1 = new int[n + 1][2];
            int atemp = -7;
            for (int j = 1; j <= n; j++) {
                // 捕获鱼的最大收益为上一条的最大收益 + 今天鱼的收益
                // 能否捕获取决于颜值是否高于上一条
                // dp2[j][0] = Max(dp2[j - 1][0], dp2[j - 1][1]) + 鱼
                // dp2[j][1] = Max(dp2[j - 1][0], dp2[j - 1][1])
                if (j == 1 || array[j - 1][0] >= atemp) {
                    dp1[j][0] = Math.max(dp1[j - 1][0], dp1[j - 1][1]) + array[j - 1][1];
                    atemp = array[j - 1][0];
                } else {
                    dp1[j][0] = Math.max(dp1[j - 1][0], dp1[j - 1][1]);
                }
                dp1[j][1] = Math.max(dp1[j - 1][0], dp1[j - 1][1]);
            }
            // 从右往左
            int[][] dp2 = new int[n + 1][2];
            atemp = -7;
            for (int j = n - 1; j >= 0; j--) {
                // 捕获鱼的最大收益为上一条的最大收益 + 今天鱼的收益
                // 能否捕获取决于颜值是否高于上一条
                // dp2[j][0] = Max(dp2[j - 1][0], dp2[j - 1][1]) + 鱼
                // dp2[j][1] = Max(dp2[j - 1][0], dp2[j - 1][1])
                if (j == n - 1 || array[j][0] >= atemp) {
                    dp2[j][0] = Math.max(dp2[j + 1][0], dp2[j + 1][1]) + array[j][1];
                    atemp = array[j][0];
                } else {
                    dp2[j][0] = Math.max(dp2[j + 1][0], dp2[j + 1][1]);
                }
                dp2[j][1] = Math.max(dp2[j + 1][0], dp2[j + 1][1]);
            }
            int max1 = Math.max(dp2[0][0], dp2[0][1]);
            int max2 = Math.max(dp1[n][0], dp1[n][1]);
            System.out.println(String.format("Case #%d: %d", i + 1, Math.max(max1, max2)));
        }
        scanner.close();
    }
}
