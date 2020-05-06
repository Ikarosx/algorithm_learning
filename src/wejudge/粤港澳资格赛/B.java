package wejudge.粤港澳资格赛;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 小明是一个被996折磨的IT男，有一天他做了一个梦，
 * 梦见他有决定工作天数的权利，于是他将每周的工作天数从5天减少到2天，
 * 这样加上2天的休息时间，每周就只有4天了，他把这种4天为单位的周命名为小明周。
 * 小明是个00后，所以他把2000年1月1日设置成小明周的开始时间（第1周的第1天）。
 * 给你今天的年月日，请你计算出今天是小明周的第几周的第几天。
 * <p>
 * 输入要求
 * 多组输入
 * <p>
 * 每组输入3个整数，y(2000<=y<=1000000)，m和d，分别代表今天的年、月、日，假设输入的m和d是合法的日期。
 * <p>
 * 输出要求
 * 每组输出2个整数，表示今天是小明周的第几周的第几天，用空格分隔，然后换行。
 *
 * @author Ikaros
 * @date 2020/4/25 9:15
 */
public class B {
    @Test
    public void test() {
        LocalDate begin = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2000, 1, 2);
        System.out.println(end.toEpochDay() - begin.toEpochDay());
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate begin = LocalDate.of(2000, 1, 1);
        while (scanner.hasNext()) {
            int y = scanner.nextInt();
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            LocalDate time = LocalDate.of(y, m, d);
            long daySub = time.toEpochDay() - begin.toEpochDay();
            System.out.println(String.format("%d %d", daySub / 4 + 1, daySub % 4 + 1));
            
        }
        scanner.close();
    }
}
