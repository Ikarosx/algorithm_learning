package collection.粤港澳资格赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 每次军训课一结束，同学们都顾不得整理自己的小板凳等训练所需物品，
 * 以最快的速度冲向食堂，军训时体能消耗太大了，他们必须轻装前进，
 * 抢到自己喜欢的食物。作为军训值日生，小明的工作量非常大，他们要将自己班级中每个同学的小板凳整理好放在一起。
 * <p>
 * 假设在整理前，班级中某些同学的小板凳是放在一起的，
 * 我们称放在一起的小板凳为一组小板凳，并且班级中所有小板凳是排成一排的。
 * 小明在整理自己班级小板凳的时候，会将相邻的两组小板凳整理到一起，
 * 组成一组新的板凳，所消耗的能量是两组板凳数量的乘积。
 * <p>
 * 根据所给出的板凳数量及分组情况，请你帮组小明计算出整理完全班所有小板凳所消耗的最少能量。
 * <p>
 * 输入要求
 * 有多组数据（不超过5组）。
 * 每组数据包含2行。
 * 第一行包含一个整数n（0<n<=100），表示共有n组小板凳。
 * 第二行包含n个整数mi（0<mi<=100），分别代表整理前每组小板凳的数量。
 * <p>
 * 输出要求
 * 每组数据输出小明整理完全班所有小板凳所消耗的最少能量。
 *
 * @author Ikaros
 * @date 2020/4/25 14:19
 */
public class O {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 共有n组小板凳
            int n = scanner.nextInt();
            // 每组小板凳的数量
            long[] array = new long[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            if (n == 1) {
                System.out.println(array[0]);
                continue;
            }
            Arrays.sort(array);
            // 需要整理n-1次
            int count = n - 1;
            long result = 0;
            while (count > 0) {
                // 找出最小的一对相邻数
                int first = n - count - 1;
                long l = array[first];
                int second = n - count;
                long l1 = array[second];
                result += l * l1;
                array[second] += array[first];
                array[first] = 0;
                long temp = array[second];
                // 将array[1]放到合适的位置
                while (second + 1 < array.length && array[second + 1] < array[second]) {
                    array[second] = array[second + 1];
                    second++;
                }
                array[second] = temp;
                count--;
            }
            System.out.println(result);
        }
        scanner.close();
    }
   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 共有n组小板凳
            int n = scanner.nextInt();
            // 每组小板凳的数量
            long[] array = new long[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            if (n == 1) {
                System.out.println(array[0]);
                continue;
            }
            // 需要整理n-1次
            int count = n - 1;
            long result = 0;
            while (count > 0) {
                long tempMin = Long.MAX_VALUE;
                int index = -1;
                // 找出最小的一对相邻数
                for (int i = 0; i < count; i++) {
                    long temp = array[i] * array[i + 1];
                    if (temp < tempMin) {
                        tempMin = temp;
                        index = i;
                    }
                }
                long l = array[index];
                long l1 = array[index + 1];
                result += l * l1;
                array[index] += array[index + 1];
                // 从array[index + 2]开始往前移动一位
                for (int i = index + 1; i < count; i++) {
                    array[i] = array[i + 1];
                }
                array[count] = 0;
                count--;
            }
            System.out.println(result);
        }
        scanner.close();
    }*/
}
//100 100 100 100 100 100 100 100 100 100
