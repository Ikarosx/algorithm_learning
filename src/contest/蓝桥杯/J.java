package contest.蓝桥杯;

import java.util.Scanner;

/**
 * 问题描述
 * 　　小蓝有黄绿蓝三种颜色的小球，分别为 R, G, B 个。同样颜色的小球没有区别。
 * 　　小蓝将这些小球从左到右排成一排，排完后，将最左边的连续同色小球个数记为 t_1，将接下来的连续小球个数记为 t_2，以此类推直到最右边的小球。
 * 　　请问，总共有多少总摆放小球的方案，使得 t_1, t_2, ... 为严格单调递增序列，即 t_1 < t_2 < t_3 < ...
 * 输入格式
 * 　　输入一行包含三个整数 R, G, B。
 * 输出格式
 * 　　输出一个整数，表示答案。
 * 样例输入
 * 3 6 0
 * 样例输出
 * 3
 * 样例说明
 * 　　用 r 表示红球，g 表示绿球，可能的方案包括：
 * 　　rrrgggggg
 * 　　grrrggggg
 * 　　ggrrrgggg
 * 样例输入
 * 2 4 6
 * 样例输出
 * 3
 * 样例说明
 * 　　用 r 表示红球，g 表示绿球，b 表示蓝球，可能的方案包括：
 * 　　rrggggbbbbbb
 * 　　grrgggbbbbbb
 * 　　brrggggbbbbb
 * 数据规模和约定
 * 　　对于30%的评测用例，1 <= R, G, B <= 10；
 * 　　对于60%的评测用例，1 <= R, G, B <= 30；
 * 　　对于所有评测用例，1 <= R, G, B <= 50。
 *
 * @author Ikarosx
 * @date 2020/12/27 19:37
 */
public class J {

    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 1; i <= r; i++) {
            dfs(r - i, g, b, 1 + i, 'r');
        }
        for (int i = 1; i <= g; i++) {
            dfs(r, g - i, b, 1 + i, 'g');
        }
        for (int i = 1; i <= b; i++) {
            dfs(r, g, b - i, 1 + i, 'b');
        }

        System.out.println(result);
    }

    private static void dfs(int r, int g, int b, int i, char c) {
        // 此时至少需要i个
        if (r == 0 && g == 0 && b == 0) {
            result++;
            return;
        }
        if (c == 'r') {
            if (g < i && b < i) {
                return;
            }
            if (r == 0 && g == 0 && b >= i) {
                result++;
                return;
            }
            if (r == 0 && b == 0 && g >= i) {
                result++;
                return;
            }
            if (g >= i) {
                for (int k = i; k <= g; k++) {
                    dfs(r, g - k, b, k + 1, 'g');
                }
            }
            if (b >= i) {
                for (int k = i; k <= b; k++) {
                    dfs(r, g, b - k, k + 1, 'b');
                }
            }
        }
        if (c == 'g') {
            if (r < i && b < i) {
                return;
            }
            if (r == 0 && g == 0 && b >= i) {
                result++;
                return;
            }
            if (b == 0 && g == 0 && r >= i) {
                result++;
                return;
            }
            if (r >= i) {
                for (int k = i; k <= r; k++) {
                    dfs(r - k, g, b, k + 1, 'r');
                }
            }
            if (b >= i) {
                for (int k = i; k <= b; k++) {
                    dfs(r, g, b - k, k + 1, 'b');
                }
            }
        }
        if (c == 'b') {
            if (g < i && r < i) {
                return;
            }
            if (b == 0 && g == 0 && r >= i) {
                result++;
                return;
            }
            if (b == 0 && r == 0 && g >= i) {
                result++;
                return;
            }
            if (r >= i) {
                for (int k = i; k <= r; k++) {
                    dfs(r - k, g, b, k + 1, 'r');
                }
            }
            if (g >= i) {
                for (int k = i; k <= g; k++) {
                    dfs(r, g - k, b, k + 1, 'g');
                }
            }
        }
    }
}
