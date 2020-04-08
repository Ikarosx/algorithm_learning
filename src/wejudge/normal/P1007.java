package wejudge.normal;

import java.util.Scanner;

/**
 * 输入要求
 * 输入一个整型n（n > 0 && n <= 30）
 * <p>
 * 输出要求
 * 在屏幕中输出（2*n+1）*（2*n+1）的图形框架，边长为n的菱形
 * 每输出一个图形后换两行
 *
 * 这题AC不了 TODO
 *
 * @author Ikaros
 * @date 2020/4/8 11:39
 */
public class P1007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = 1;
            while (a <= n + 1) {
                printStar(2 * n + 1, a++);
            }
            a--;
            a--;
            while (a >= 1) {
                printStar(2 * n + 1, a--);
            }
            System.out.println();
            System.out.println();
        }
        scanner.close();
    }
    
    private static void printStar(int length, int a) {
        int mid = a * 2 - 1;
        int hand = (length - mid) / 2;
        for (int i = 0; i < hand; i++) {
            System.out.print(".");
        }
        for (int i = 0; i < mid; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < hand; i++) {
            System.out.print(".");
        }
        System.out.println();
    }
}
