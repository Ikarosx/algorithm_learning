package interview.微众银行.微众银行20201015;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 时间限制： 5000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 给一个数不包含前导0的数n，现在将n的各位数字的顺序重组，在这些数中，有多少个数是m的倍数？ 例如112,重组后有三个数：112,121,211
 *
 *
 *
 * 输入描述
 * 输入包含两个数，n和m，含义如题面所示
 *
 * 输出描述
 * 输出一个数，代表m的倍数的个数。
 *
 *
 * 样例输入
 * 112 4
 * 样例输出
 * 1
 *
 * @author Ikarosx
 * @date 2020/10/15 20:41
 */
public class C数字的重排列 {

    static int result;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int length = String.valueOf(n).length();
            int[] ints = new int[10];
            // 计算各个位置的数有多少个
            while (n != 0) {
                ints[n % 10]++;
                n /= 10;
            }
            result = 0;
            dfs(ints, 0, length, m, "");
            System.out.println(result);
        }
        scanner.close();
    }

    private static void dfs(int[] ints, int i, int length, int m, String resultString) {
        if (i == length) {
            Integer integer = Integer.valueOf(resultString);
            // 重复组合
            if (integer % m == 0 && set.add(integer)) {
                result++;
            }
            return;
        }
        for (int j = 0; j < ints.length; j++) {
            // 有余数
            if (ints[j] > 0) {
                // 前导不能为0
                if (j == 0 && i == 0) {
                    continue;
                }
                ints[j]--;
                dfs(ints, i + 1, length, m, resultString + j);
                ints[j]++;
            }
        }
    }
}
