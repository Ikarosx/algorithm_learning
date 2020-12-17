package interview.百度.百度2021校招笔试1021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/12 20:22
 */
public class C后缀变换 {

    static int result = 0;
    // 存放某个字符串经过第几次操作后得到
    static Map<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            result = 0;
            String S = scanner.next();
            String T = scanner.next();
            int k = scanner.nextInt();

            dfs(S, T, 1, k);
            System.out.println(result);
        }
        scanner.close();
    }

    private static void dfs(String s, String t, int i, int k) {
        if (i > k) {
            result += s.equals(t) ? 1 : 0;
            result %= 1000000007;
            return;
        }
        int length = s.length();
        for (int j = 1; j < length; j++) {
            String after = s.substring(j);
            String before = s.substring(0, j);
            String string = after + before;
            map.putIfAbsent(string, new ArrayList<>());
            List<Integer> integers = map.get(string);
            if (integers.size() == 3) {
                int cycle = integers.get(2) - integers.get(1);
                if ((k - i) % cycle == 0) {
                    result++;
                    result %= 1000000007;
                }
                return;
            } else {
                // 第i次操作得到了该字符串
                integers.add(i);
            }
            dfs(string, t, i + 1, k);
        }
    }

}
