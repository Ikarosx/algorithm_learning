package interview.神策.神策秋招20201020;

import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/20 16:32
 */
public class B发工资 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            int[] money = {100, 20, 10, 5, 1};
            int result = 0;
            for (int i : money) {
                int num = sum / i;
                result += num;
                sum -= num * i;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
