package collection.粤港热身赛;

import java.util.Scanner;

/**
 * 在计算机专业课中，经常有互评分组报告这个环节。
 * 一个组上台介绍自己的工作，其他组在台下为其表现评分。
 * 最后这个组的互评成绩是这样计算的：所有其他组的评分中，
 * 去掉一个最高分和一个最低分，剩下的分数取平均分记为 G1；
 * 老师给这个组的评分记为 G2。该组得分为 (G1+G2)/2，
 * 最后结果四舍五入后保留整数分。
 * 本题就要求你写个程序帮助老师计算每个组的互评成绩。
 * <p>
 * 输入要求
 * 输入第一行给出两个正整数N（> 3）和M，分别是分组数和满分，均不超过100。
 * 随后N行，每行给出该组得到的N个分数（均保证为整型范围内的整数），
 * 其中第1个是老师给出的评分，后面 N-1 个是其他组给的评分。
 * 合法的输入应该是[0, M]区间内的整数，
 * 若不在合法区间内，则该分数须被忽略。
 * 题目保证老师的评分都是合法的，并且每个组至少会有3个来自同学的合法评分。
 * <p>
 * 输出要求
 * 为每个组输出其最终得分。每个得分占一行。
 *
 * @author Ikaros
 * @date 2020/4/18 20:28
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 分组数
        int N = scanner.nextInt();
        // 满分
        int M = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int max = -1;
            int min = M + 1;
            int sum = 0;
            int count = 0;
            int G1 = scanner.nextInt();
            for (int j = 1; j < N; j++) {
                int credit = scanner.nextInt();
                if (credit >= 0 && credit <= M) {
                    max = credit > max ? credit : max;
                    min = credit < min ? credit : min;
                    sum += credit;
                    count++;
                }
            }
            sum -= min;
            sum -= max;
            count -= 2;
            double result = (sum / (count + 0.0) + G1) / 2.0;
            System.out.println(Math.round(result));
        }
        scanner.close();
    }
}
