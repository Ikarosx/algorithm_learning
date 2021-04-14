package interview.爱客科技;

import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2021/04/14
 */
public class B发奖金 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n组数据
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        long[] money = new long[n];
        // 初始化
        money[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ints[i] > ints[i - 1]) {
                // 如果当前数大于上一个数
                // 更新当前需要花费金额
                money[i] = money[i - 1] + 1;
            } else if (ints[i] < ints[i - 1]) {
                // 如果当前数小于上一个数
                money[i] = 1;
                // 更新之前的金额
                int temp = i - 1;
                while (temp >= 0 && ints[temp] > ints[temp + 1] && money[temp] <= money[temp + 1]) {
                    money[temp] = money[temp + 1] + 1;
                    temp--;
                }
            } else {
                money[i] = 1;
            }
        }
        long result = 0;
        for (int i = 0; i < money.length; i++) {
            result += money[i];
        }
        System.out.println(result);
        scanner.close();
    }
}
