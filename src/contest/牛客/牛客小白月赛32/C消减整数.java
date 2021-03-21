package contest.牛客.牛客小白月赛32;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/11163/C
 * 来源：牛客网
 * <p>
 * 给出一个正整数H，从1开始减，第一次必须减1，每次减的数字都必须和上一次相同或者是上一次的两倍，请问最少需要几次能把H恰好减到0。
 * 输入描述:
 * 第一行给出一个正整数{T}T，1 \le T \le 10^41≤T≤10
 * 4
 * <p>
 * <p>
 * 接下来T行每行一个H,1 \le H \le 10^9H,1≤H≤10
 * 9
 * <p>
 * <p>
 * 输出描述:
 * 每行一个正整数代表最少的次数
 * 示例1
 * 输入
 * 复制
 * 3
 * 3
 * 5
 * 7
 * 输出
 * 复制
 * 2
 * 3
 * 3
 *
 * @author Ikarosx
 * @date 2021/03/20
 */
public class C消减整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[31];
        for (int i = 0; i < 31; i++) {
            ints[i] = 1 << i;
        }
        System.out.println(Arrays.toString(ints));
        int i = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            int k = scanner.nextInt();
            int c = 0;
            int l = 0;
            for (; l < 31 && ints[l] <= k; l++) {
                k -= ints[l];
            }
            c += l;
            while (k != 0) {
                if (ints[l] > k) {
                    l--;
                    continue;
                }
                c += k / ints[l];
                k -= k / ints[l] * ints[l];
            }
            System.out.println(c);
        }
        scanner.close();
    }

}
