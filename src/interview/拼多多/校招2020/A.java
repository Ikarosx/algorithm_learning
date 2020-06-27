package interview.拼多多.校招2020;

import java.util.Scanner;

/**
 * 多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。
 * 多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
 * 通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
 * 那么请问聪明的你，是否已经知道了应该如何操作呢？
 *
 * @author Ikaros
 * @date 2020/6/6 13:44
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int k = scanner.nextInt();
                if (k == 1) {
                    System.out.println(1);
                    continue;
                }
                double log = Math.log(k) / Math.log(2);
                if ((k & 1) == 1) {
                    double ceil = Math.ceil(log);
                    System.out.println((int) ceil);
                } else {
                    int result = (int) log;
                    if (result == log) {
                        result++;
                    } else {
                        result = (int) Math.ceil(log);
                    }
                    System.out.println(result);
                }
            }
        }
        scanner.close();
    }
}
