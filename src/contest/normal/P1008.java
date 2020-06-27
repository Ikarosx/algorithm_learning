package contest.normal;

import java.util.Scanner;

/**
 * 输入要求
 * 输入数据包含多个测试实例，每个实例占一行，由两个正整数A和B组成（1<=A,B<=1000000），如果A=0,
 * B=0，则表示输入数据的结束，不做处理。
 * 输出要求
 * 对于每个测试实例，请输出A^B的最后四位表示的整数，每个输出占一行。
 *
 * @author Ikaros
 * @date 2020/4/8 12:16
 */
public class P1008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                return;
            }
            if (a == 0 || b == 0) {
                System.out.println(0);
                continue;
            }
            int result = a;
            while (b-- > 1) {
                result = result * a % 10000;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
