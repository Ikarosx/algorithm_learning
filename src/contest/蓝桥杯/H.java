package contest.蓝桥杯;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个序列 a_1, a_2, ..., a_n。其中 a_1 < a_2 < ... < a_n。
 * 　　相邻两个数之间的差（后一个数减前一个数）称为它们的间隙。
 * 　　请问序列中最大的间隙值是多少？
 * 输入格式
 * 　　输入的第一行包含一个整数 n，表示序列的长度。
 * 　　第二行包含 n 个正整数，为给定的序列。
 * 输出格式
 * 　　输出一个整数，表示序列中最大的间隙值。
 * 样例输入
 * 5
 * 1 3 8 9 12
 * 样例输出
 * 5
 * 样例说明
 * 　　a_3 - a_2 = 5。
 * 数据规模和约定
 * 　　对于所有评测用例，1 <= n <= 1000，1 <= a_i <= 100000。
 *
 * @author Ikarosx
 * @date 2020/12/27 19:04
 */
public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pre = scanner.nextInt();
        int max = 0;
        for (int i = 1; i < n; i++) {
            int cur = scanner.nextInt();
            max = Math.max(max, cur - pre);
            pre = cur;
        }
        if (n == 1) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }
}
