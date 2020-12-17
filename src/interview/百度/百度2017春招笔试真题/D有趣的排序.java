package interview.百度.百度2017春招笔试真题;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 *
 * 输入描述:
 * 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
 *
 * 输出描述:
 * 输出一个整数表示最少的操作次数。
 *
 * 输入例子1:
 * 4
 * 19 7 8 25
 *
 * 输出例子1:
 * 2
 *
 * @author Ikarosx
 * @date 2020/10/12 15:09
 */
public class D有趣的排序 {

    public static void main(String[] args) {
        // TODO
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.add(scanner.nextInt());
            }
            // 每次找到最小值左边有多少个数,累加即为答案

        }
        scanner.close();
    }
}
