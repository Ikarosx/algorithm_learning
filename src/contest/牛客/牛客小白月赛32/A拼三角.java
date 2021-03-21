package contest.牛客.牛客小白月赛32;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/11163/A
 * 来源：牛客网
 * <p>
 * 给出6根棍子，能否在选出3根拼成一个三角形的同时剩下的3根也能组成一个三角形？
 * 输入描述:
 * 首先在一行中给出一个 t,1 \le t \le 10^3t,1≤t≤10
 * 3
 * ，代表测试数据的组数
 * <p>
 * 接下来t行，每行给出6个数字代表棍子长度，棍子长度为正且小于10^910
 * 9
 * <p>
 * 输出描述:
 * 在一行中输出 “Yes” or “No”
 * 示例1
 * 输入
 * 复制
 * 2
 * 1 1 1 1 1 1
 * 1 2 3 4 5 6
 *
 * @author Ikarosx
 * @date 2021/03/20
 */
public class A拼三角 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int[] arrs = new int[6];
            for (int j = 0; j < 6; j++) {
                arrs[j] = scanner.nextInt();
            }
            System.out.println(calc(arrs));

        }
        scanner.close();
    }

    private static String calc(int[] arrs) {
        for (int j = 0; j < 6; j++) {
            for (int k = j + 1; k < 6; k++) {
                for (int l = k + 1; l < 6; l++) {
                    if (isS(j, k, l, arrs)) {
                        return "Yes";
                    }
                }
            }
        }
        return "No";
    }

    private static boolean isS(int j, int k, int l, int[] arrs) {
        int[] a = new int[3];
        int[] b = new int[3];
        int ca = 0;
        int cb = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (i == j || i == k || i == l) {
                a[ca++] = arrs[i];
            } else {
                b[cb++] = arrs[i];
            }
        }
        // 判断三边是否是三角形
        return isSImpl(a) && isSImpl(b);
    }

    private static boolean isSImpl(int[] a) {
        int a1 = a[0];
        int a2 = a[1];
        int a3 = a[2];
        // 两边和大于第三边
        if (a1 + a2 <= a3 || a1 + a3 <= a2 || a2 + a3 <= a1) {
            return false;
        }
        // 两边差小于第三边
        if (Math.abs(a1 - a3) >= a2 || Math.abs(a1 - a2) >= a3 || Math.abs(a2 - a3) >= a1) {
            return false;
        }
        return true;
    }
}
