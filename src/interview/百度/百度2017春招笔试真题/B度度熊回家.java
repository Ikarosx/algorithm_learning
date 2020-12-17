package interview.百度.百度2017春招笔试真题;

import java.util.Scanner;

/**
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
 *
 * 输入描述:
 * 输入一个正整数N, N <= 50。
 *
 * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 *
 * 输出描述:
 * 输出一个整数表示度度熊最少需要走的距离。
 *
 * 输入例子1:
 * 4
 * 1 4 -1 3
 *
 * 输出例子1:
 * 4
 *
 * @author Ikarosx
 * @date 2020/10/12 14:31
 */
public class B度度熊回家 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ints = new int[N];
        // 不忽略的时候
        int count = 0;
        int[] d = new int[N];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
            if (i != 0) {
                int abs = Math.abs(ints[i] - ints[i - 1]);
                count += abs;
                d[i] = abs;
            }
        }
        // 计算忽略第i个后能节省多少路程
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N - 1; i++) {
            // 忽略第i个
            max = d[i] == d[i + 1] ? 0 : Math.max(max, Math.min(d[i], d[i + 1]) * 2);
        }
        System.out.println(count - max);
        scanner.close();
    }
}
