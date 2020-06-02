package collection.normal;

import java.util.Scanner;

/**
 * 输入要求
 * 输入两个整型a,b,题目保证a和b在0——100之间（注意，并没有说a < b 哦）
 * 输出要求
 * 输出a与b之间的（包括a和b）的所有数之和，每个输出占一行
 *
 * @author Ikaros
 * @date 2020/4/8 8:59
 */
public class P1004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int min = a < b ? a : b;
            int max = a < b ? b : a;
            int n = max - min + 1;
            System.out.println((2 * min * n + n * (n - 1)) / 2);
        }
        scanner.close();
    }
}
