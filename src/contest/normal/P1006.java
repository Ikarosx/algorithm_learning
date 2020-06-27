package contest.normal;

import java.util.Scanner;

/**
 * 小学一年级的小明最近有一次考试（他只考两科，语文和数学），他虽然知道了分数，但是却不知道自己的分数等级是如何划分的，因为老师评总成绩的时候是按照A科目的等级+B科目的等级来划分的。
 * 下面就麻烦你们帮他算算他的成绩等级是什么吧。
 * 对于分数的划分：
 * 100 - 90 A
 * 89 - 80 B
 * 79 - 70 C
 * 69 - 60 D
 * 60以下 E
 * 两科成绩的等级划分为两科等级平均的等级，若没有中间等级，那么将向更厉害的等级靠拢（老师总不希望学生成绩等级低吧）
 * 比如：一科95，一科75，那么是A + C,最终等级为B
 * 一科95，一科85，那么A + B，最终等级为A
 * <p>
 * 输入要求
 * 输入两个整型a，b（0<= a,b<=100）
 * <p>
 * 输出要求
 * 输出小明的最终成绩等级，每个输出占一行
 *
 * @author Ikaros
 * @date 2020/4/8 9:23
 */
public class P1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char a = changeIntToChar(scanner.nextInt());
            char b = changeIntToChar(scanner.nextInt());
            int result = 65;
            if (Math.abs(a - b) == 1) {
                // 没有中间等级输出高等级
                result = a > b ? b : a;
            } else {
                // 有中间等级
                result = (a + b) / 2;
            }
            System.out.println(result < 'A' ? 'A' : (char) result);
        }
        scanner.close();
    }
    
    public static char changeIntToChar(int a) {
        if (a >= 90) {
            return 'A';
        } else if (a >= 80) {
            return 'B';
        } else if (a >= 70) {
            return 'C';
        } else if (a >= 60) {
            return 'D';
        } else {
            return 'E';
        }
    }
}
