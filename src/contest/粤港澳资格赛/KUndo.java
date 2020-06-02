package collection.粤港澳资格赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * GM老师有n个学生，每个学生需要完成一个项目。
 * GM老师需要花Mi分钟为第i个学生布置任务，
 * 然后这个学生会独立不间断的用Ri分钟完成项目。
 * 请问GM老师需要选择怎样的顺序来布置任务，
 * 才能使得所有项目尽早执行完（也就是最后一个完成的学生尽快结束）。
 * 注意，GM老师不能同时给两个学生布置项目，但学生可以同时执行他们各自的项目。
 * <p>
 * 输入要求
 * 输入n+1行
 * <p>
 * 第1行输入项目数n
 * <p>
 * 第2行到n+1行，每行输入GM老师为这n个学生布置任务所需时间M和完成任务所需时间R
 * <p>
 * 所有输入均为整数，其取值范围为[1, 1000]
 * <p>
 * 输出要求
 * 输出项目个数和所有项目完成的最短时间（分钟），格式如下：
 * <p>
 * Project n: m（其中，n代表项目个数，m代表最短时间，注意换行）
 * <p>
 * 详见输出样例
 *
 * @author Ikaros
 * @date 2020/4/25 12:11
 */
public class KUndo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[][] array = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        Arrays.sort(array, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1].compareTo(o1[1]);
            }
        });
        // 当前的时间
        int current = 0;
        // 结束时的最少时间
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            // 加上老师布置的时间后
            int m = current + array[i][0];
            // 如果大于结束时的最少时间，则更新
            if (m > result) {
                result = m;
            }
            current = m;
            int r = current + array[i][1];
            if (r > result) {
                result = r;
            }
        }
        System.out.println(String.format("Project %d: %d", n, result));
        scanner.close();
    }
}
