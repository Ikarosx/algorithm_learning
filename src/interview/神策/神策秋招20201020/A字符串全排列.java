package interview.神策.神策秋招20201020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/20 16:15
 */
public class A字符串全排列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            List<String> x = fullSort(string);
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (String s : x) {
                builder.append("'");
                builder.append(s);
                builder.append("'");
                builder.append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
            System.out.println(builder.toString());
        }
        scanner.close();
    }

    private static List<String> fullSort(String string) {
        LinkedList<String> result = new LinkedList<>();
        boolean[] visited = new boolean[string.length()];
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        dfs(chars, 0, "", visited, result);
        return result;
    }

    private static void dfs(char[] chars, int i, String s, boolean[] visited, List<String> result) {
        if (i == chars.length) {
            result.add(s);
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(chars, i + 1, s + chars[j], visited, result);
                visited[j] = false;
            }
        }
    }
}
