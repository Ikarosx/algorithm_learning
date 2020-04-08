package wejudge.acm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 给定一个日期，输出这个日期是该年的第几天。
 * <p>
 * 输入要求
 * 输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见样例输入,另外，可以向你确保所有的输入数据是合法的。
 * <p>
 * 输出要求
 * 对于每组输入数据，输出一行，表示该日期是该年的第几天。
 *
 * @author Ikaros
 * @date 2020/4/8 16:25
 */
public class P1023_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        while (scanner.hasNext()) {
            // 使用LocalDate可以很方便操作时间
            LocalDate date = LocalDate.parse(scanner.next(), formatter);
            System.out.println(date.getDayOfYear());
        }
        scanner.close();
    }
}
