package contest.蓝桥杯;


import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/12/27 18:43
 */
public class F {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a * b;
        if (sum % 2 == 0) {
            System.out.println(sum / 2);
        } else {
            System.out.println(a * b / 2.0);
        }
    }
}
