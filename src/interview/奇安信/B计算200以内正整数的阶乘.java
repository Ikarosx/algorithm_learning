package interview.奇安信;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/18 15:18
 */
public class B计算200以内正整数的阶乘 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (i < 1 || i > 200) {
                System.out.println("Error");
                continue;
            }
            BigDecimal result = new BigDecimal(1);
            for (int j = 1; j <= i; j++) {
                result = result.multiply(new BigDecimal(j));
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
