package interview.字节跳动.字节跳动2019春招研发部分编程题汇总;

import java.util.Scanner;

/**
 * 小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，且每个城市只去一次。由于经费有限，希望能够通过合理的路线安排尽可能的省一些路上的花销。给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。
 *
 * 输入描述:
 * 城市个数n（1<n≤20，包括北京）
 *
 * 城市间的车票价钱 n行n列的矩阵 m[n][n]
 *
 * 输出描述:
 * 最小车费花销 s
 *
 * 输入例子1:
 * 4
 * 0 2 6 5
 * 2 0 4 4
 * 6 4 0 2
 * 5 4 2 0
 *
 * 输出例子1:
 * 13
 *
 * 例子说明1:
 * 共 4 个城市，城市 1 和城市 1 的车费为0，城市 1 和城市 2 之间的车费为 2，城市 1 和城市 3 之间的车费为 6，城市 1 和城市 4 之间的车费为 5，依次类推。假设任意两个城市之间均有单程票可购买，且票价在1000元以内，无需考虑极端情况。
 *
 * @author Ikarosx
 * @date 2020/10/11 0:36
 */
public class E毕业旅游 {

    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[j][k] = scanner.nextInt();
            }
        }
        visited = new boolean[n];
        visited[0] = true;
        dfs(matrix, 1, n, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int[][] matrix, int i, int n, int cost, int currentCity) {
        if (i == n) {
            result = Math.min(result, cost + matrix[currentCity][0]);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(matrix, i + 1, n, cost + matrix[currentCity][j], j);
                visited[j] = false;
            }
        }
    }
}
