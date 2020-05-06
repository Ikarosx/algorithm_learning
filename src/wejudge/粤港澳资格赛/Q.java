package wejudge.粤港澳资格赛;

import java.util.Scanner;

/**
 * 2020年，注定是不平凡的一年。疫情防控期间，小明的体育老师坚持“开学不返校，网教不停学”的原则，
 * 遵循线上教学的规律，精心组织教学设计，倾力打造线上体育课堂，其中一项是让同学们在家里玩跳格子的游戏。
 * <p>
 * 游戏一共有n个格子，排成一列，小明每次只能跳1个格子或2个格子。
 * 小明需要从格子的一端跳向另一端，请问他一共有多少种跳法？
 * <p>
 * 输入要求
 * 多组输入。
 * <p>
 * 每组输入一个格子的数量n（1<=n<=35）。
 * <p>
 * 输出要求
 * 每组输出一个整数，代表有多少种跳法，然后换行。
 *
 * @author Ikaros
 * @date 2020/4/25 12:30
 */
public class Q {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n < 4 ? 4 : n + 1];
            array[1] = 1;
            array[2] = 2;
            array[3] = 3;
            for (int i = 4; i <= n; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            System.out.println(array[n]);
        }
        scanner.close();
    }
}
