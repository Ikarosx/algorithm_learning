package 奇安信;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Ikarosx
 * @date 2021/04/14
 */
public class A单车摆放问题 {
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // num

       //ssdasd
        int n = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String c = scanner.next();
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<String> strings = map.keySet();
        String[] chars = new String[strings.size()];
        boolean[] visited = new boolean[strings.size()];
        int zz = 0;
        for (String string : strings) {
            chars[zz++] = string;
        }
        n = strings.size();
        for (int i = 0; i < n; i++) {
            if (chars[i].equals("B")) {
                continue;
            }
            String append = "";
            for (Integer integer = 0; integer < map.get(chars[i]); integer++) {
                append += chars[i] + "-";
            }
            visited[i] = true;
            StringBuilder sb = new StringBuilder();
            dfs(1, visited, chars, sb.append(append), chars[i].equals("A") ? true : false, map);
            for (Integer integer = 0; integer < map.get(chars[i]); integer++) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            visited[i] = false;
        }
        System.out.print(result);
        scanner.close();
    }

    private static void dfs(int count, boolean[] visited, String[] chars, StringBuilder sb, boolean flag, Map<String, Integer> map) {
        if (count == chars.length) {
            result++;
            System.out.print(sb.toString().substring(0, sb.length() - 1) + " ");
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                if (chars[i].equals("B") && !flag) {
                    continue;
                }
                if (chars[i].equals("B") && flag) {
                    flag = false;
                }
                visited[i] = true;
                if (chars[i].equals("A")) {
                    flag = true;
                }
                String append = "";
                for (Integer integer = 0; integer < map.get(chars[i]); integer++) {
                    append += chars[i] + "-";
                }
                dfs(count + 1, visited, chars, sb.append(append), flag, map);
                for (Integer integer = 0; integer < map.get(chars[i]); integer++) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
                visited[i] = false;
                if (chars[i].equals("A")) {
                    flag = false;
                }
                if (chars[i].equals("B")) {
                    flag = true;
                }
            }
        }
    }
}
