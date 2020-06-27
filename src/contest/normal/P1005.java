package contest.normal;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 输入要求
 * 输入浮点型a b（范围在double以内）
 * <p>
 * 输出要求
 * 先求出a+b的值
 * 再判断它是否是伪整数，如果是：
 * 输出"这是一个伪整数，它的值为：a"
 * 如果不是：
 * 输出"这是一个浮点数，它的值为：a"
 *
 * @author Ikaros
 * @date 2020/4/8 9:12
 */
public class P1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double sum = a + b;
            int intSum = (int) sum;
            if (intSum == sum) {
                System.out.println(String.format("这是一个伪整数，它的值为：%d", intSum));
            } else {
                System.out.println(String.format("这是一个浮点数，它的值为：%.2f", sum));
            }
        }
        scanner.close();
    }
    
    @Test
    public void p1005Test() {
        double a = 1.2;
        double b = 2.8;
        System.out.println(a + b == 4);
    }
}
