package contest.牛客.牛客练习赛77;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/11160/A
 * 来源：牛客网
 *
 * 给定一个n, 定义mind(n)为n最小的约数，maxd(n)为n最大的约数
 * 求sum i=1..n mind(i) + sum i=1..n maxd(i)
 * 输入描述:
 * 给定的n
 * 输出描述:
 * 输出要求的答案
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 20
 * 备注:
 * 数据范围:
 * 1<=n<=1e9
 *
 * @author Ikarosx
 * @date 2021/02/26
 */
public class A小G的sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 最小公约数为1
        long n = scanner.nextLong();
        long result = 0;
        result += n;
        result += (n  + 1) * n / 2;
        System.out.println(result);
        scanner.close();
    }

    //private static long maxd(long i) {
    //    for (long l = i; l > 0; l--) {
    //
    //    }
    //    return 0;
    //}
}
