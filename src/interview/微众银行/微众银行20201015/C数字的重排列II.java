package interview.微众银行.微众银行20201015;

import java.util.Arrays;
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
public class C数字的重排列II {

    static int result;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] ints = new int[10];
            // 计算各个位置的数有多少个
            while (n != 0) {
                ints[n % 10]++;
                n /= 10;
            }
            result = 0;
            // 获得排列最小的数
            int min = getMin(ints);
            // 获得排列最大的数
            int max = getMax(ints);
            int start = min / m * m;
            while (start <= max) {
                if (valid(start, ints)) {
                    result++;
                }
                start += m;
            }
            System.out.println(result);
        }
        scanner.close();
    }

    private static boolean valid(int start, int[] ints) {
        int[] startInts = new int[10];
        // 计算各个位置的数有多少个
        while (start != 0) {
            startInts[start % 10]++;
            start /= 10;
        }
        return Arrays.equals(startInts, ints);
    }

    private static int getMax(int[] ints) {
        StringBuilder result = new StringBuilder();
        for (int i = ints.length - 1; i >= 0; i--) {
            for (int j = 0; j < ints[i]; j++) {
                result.append(i);
            }
        }
        return Integer.valueOf(result.toString());
    }

    private static int getMin(int[] ints) {
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        if (ints[1] > 0) {
            result.append("1");
            ints[1]--;
            flag = true;
        }
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i]; j++) {
                result.append(i);
            }
        }
        ints[1] += flag ? 1 : 0;
        return Integer.valueOf(result.toString());
    }


}
