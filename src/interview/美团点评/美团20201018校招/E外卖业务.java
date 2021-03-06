package interview.美团点评.美团20201018校招;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美和小团所在的城市包含N个乡镇，乡镇被编号为1到N并按中心化管理，N个乡镇按层级构成树型关系：即以1号乡镇为中心(根)，对于2号到N号乡镇，i号乡镇的上级乡镇为A[i]号乡镇（1<=A[i]<i），或者说i号乡镇是A[i]号乡镇的一个下属乡镇。每个乡镇只有一个上级乡镇（除了1号乡镇没有上级乡镇）和若干个下属乡镇。
 *
 * 该城市由2(N-1)条单向道路连接各乡镇。除了1号乡镇，每个乡镇都有一条长为1的高速公路通向其上级乡镇，而其上级乡镇则有一条长为2的普通公路通向该乡镇。
 *
 * 现在，小美和小团打算在该城市开展外卖业务。若他们在某个乡镇设立站点，则从该乡镇出发距离不超过2的乡镇都可以享受到他们的外卖服务。那么，他们想知道至少要在多少个乡镇设立站点，才能使所有乡镇都享受到外卖服务。
 *
 *
 *
 * 输入描述
 * 第一行输入一个整数T（1<=T<=10），表示数据组数。
 *
 * 每组数据占两行，第一行输入一个整数N（1<=N<=10^5）；
 *
 * 第二行输入N-1个由空格隔开的整数，表示A[2]到A[N]（1<=A[i]<i）。
 *
 * 输出描述
 * 每组数据输出占一行，输出一个整数，表示所需设立的站点数目的最小值。
 *
 *
 * 样例输入
 * 1
 * 5
 * 1 1 3 3
 * 样例输出
 * 2
 *
 * 提示
 * 可以在1号和3号乡镇设立站点。
 *
 * @author Ikarosx
 * @date 2020/10/18 11:40
 */
public class E外卖业务 {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int[] ints = new int[N];
                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int j = 1; j < N; j++) {
                    ints[j] = scanner.nextInt();
                    map.putIfAbsent(ints[j], new ArrayList<>());
                    map.get(ints[j]).add(j);
                }
                result = Integer.MAX_VALUE;
                boolean[] visited = new boolean[N];
                dfs(ints, visited, map, 0, N, 0);
                System.out.println(result);
            }
        }
        scanner.close();
    }

    private static void dfs(int[] ints, boolean[] visited, Map<Integer, List<Integer>> map, int i,
        int n, int sum) {
        if (i == n) {
            if (vlidVisited(visited)) {
                result = Math.min(result, sum);
            }
            return;
        }
        for (int j = i; j < ints.length; j++) {
            visited[i] = true;
            List<Integer> integers = map.get(j);
            if (integers != null) {
                for (Integer integer : integers) {
                    visited[integer] = true;
                }
            }
            visited[ints[j]] = true;
            visited[ints[ints[j]]] = true;
            dfs(ints, visited, map, i + 1, n, sum + 1);
            if (integers != null) {
                for (Integer integer : integers) {
                    visited[integer] = false;
                }
            }
            visited[i] = false;
            visited[ints[j]] = false;
            visited[ints[ints[j]]] = false;
            dfs(ints, visited, map, i + 1, n, sum);
        }
    }

    private static boolean vlidVisited(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
