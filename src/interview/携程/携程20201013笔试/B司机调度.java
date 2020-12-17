package interview.携程.携程20201013笔试;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/13 11:11
 */
public class B司机调度 {

    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>(100);
        while (scanner.hasNextInt()) {
            int incomeOfA = scanner.nextInt();
            int incomeOfB = scanner.nextInt();
            list.add(new int[]{incomeOfA, incomeOfB});
            //Start coding -- Input Data

            //Start coding
        }
        int N = list.size() / 2;
        if ((list.size() & 1) != 0) {
            System.out.println("error");
            return;
        }
        boolean[] visited = new boolean[list.size()];
        dfs(list, 0, 0, 0, N, visited);
        System.out.println(result);
    }

    private static void dfs(ArrayList<int[]> list, int current, int a, int b, int n,
        boolean[] visited) {
        // 只计算A区域
        if (a == n || b == n) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                // 访问过的加上A区域
                sum += visited[i] ? list.get(i)[0] : list.get(i)[1];
                result = Math.max(sum, result);
            }
            return;
        }
        for (int i = current; i < list.size(); i++) {
            visited[i] = true;
            dfs(list, current + 1, a + 1, b, n, visited);
            visited[i] = false;
            dfs(list, current + 1, a, b + 1, n, visited);
        }
    }


}