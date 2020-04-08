package wejudge.normal;

import java.util.Scanner;

/**
 * 一个数如果恰好等于它的因子之和，那么这个数就被我们称为完数，例如6 = 1 + 2 + 3。
 * 那么现在请小伙伴们求一下各个数是否是完数吧（一个数的因子包括1和它本身）
 * 但是，完数的计算并不把本身计算在内
 * <p>
 * 输入要求
 * 输入一个整型n(2 <= n <= 100000)
 * 输出要求
 * 输出YES 或者 NO，每个输出占一排
 *
 * @author Ikaros
 * @date 2020/4/8 16:08
 */
public class P1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int result = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    result += i;
                }
            }
            System.out.println(result == n ? "YES" : "NO");
        }
        scanner.close();
    }
}
