package contest.蓝桥杯;

import java.util.Scanner;

/**
 * 问题描述
 * 　　小蓝正在上小学，老师要求同学们在暑假每天记日记。可是小蓝整个暑假都在玩，直到最后一天才想起要记日记。于是小蓝赶紧编了一些日记交给老师。
 * 　　没想到，日记很快就被老师发现了问题，原来小蓝记完8月31日的日记，竟又记了8月32日和8月33日的日记。这显然是有问题的，因为根本没有8月32日和8月33日。
 * 　　给定一个月份和一个日期，请问2021年有没有这一天。
 * 输入格式
 * 　　输入的第一行包含一个整数 m，表示月份。
 * 　　第二行包含一个整数 d，表示日期。
 * 输出格式
 * 　　如果2021年有 m 月 d 日，输入 yes，否则输出 no。
 * 样例输入
 * 8
 * 32
 * 样例输出
 * no
 * 样例输入
 * 2
 * 28
 * 样例输出
 * yes
 *
 * @author Ikarosx
 * @date 2020/12/27 18:46
 */
public class G {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        String result = "yes";
        if (m > 12 || m < 1 || d < 1 || d > 31) {
            result = "no";
        }
        if (d == 31) {
            int[] ints = new int[]{1, 3, 5, 7, 8, 10, 12};
            boolean flag = false;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == m) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result = "no";
            }
        }
        if (m == 2 && d > 28) {
            result = "no";
        }
        System.out.println(result);
    }
}
