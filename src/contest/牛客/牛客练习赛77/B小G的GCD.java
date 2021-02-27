package contest.牛客.牛客练习赛77;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/11160/B
 * 来源：牛客网
 *
 * 小G给你两个数n,k
 * 我们定义F(x)为i从1~x i%k==0的i的和
 * 现在希望你求出sum i=1..n F(i)
 * 输入描述:
 * 给定两个数n，k
 * 输出描述:
 * 要求输出的答案
 * 示例1
 * 输入
 * 复制
 * 2 1
 * 输出
 * 复制
 * 4
 * 示例2
 * 输入
 * 复制
 * 5 3
 * 输出
 * 复制
 * 9
 * 备注:
 * 数据范围：
 * 1<=n,k<=1e6
 *
 * @author Ikarosx
 * @date 2021/02/26
 */
public class B小G的GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long base = 0;
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long result = 0;
        for (int j = 1; j <= n; j++) {
            result += base;
            if (j % k == 0) {
                result += j;
                base += j;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
