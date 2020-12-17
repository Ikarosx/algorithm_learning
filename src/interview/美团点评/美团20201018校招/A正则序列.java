package interview.美团点评.美团20201018校招;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序。
 *
 * 有一天小团得到了一个长度为n的任意序列，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
 *
 * 请问他最少用多少次操作可以把这个序列变成正则序列？
 *
 *
 *
 * 输入描述
 * 输入第一行仅包含一个正整数n，表示任意序列的长度。(1<=n<=20000)
 *
 * 输入第二行包含n个整数，空格隔开，表示给出的序列，每个数的绝对值都小于10000。
 *
 * 输出描述
 * 输出仅包含一个整数，表示最少的操作数量。
 *
 *
 * 样例输入
 * 5
 * -1 2 3 10 100
 * 样例输出
 * 103
 *
 * @author Ikarosx
 * @date 2020/10/18 10:03
 */
public class A正则序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = scanner.nextInt();
            }
            // 对数组排序
            Arrays.sort(ints);
            int result = 0;
            // 遍历每个数
            for (int i = 0; i < n; i++) {
                int temp = ints[i];
                // 如果对应值不是正确的
                if (temp != i + 1) {
                    result += Math.abs(temp - i - 1);
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
