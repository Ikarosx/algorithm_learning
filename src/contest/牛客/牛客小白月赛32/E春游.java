package contest.牛客.牛客小白月赛32;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/11163/E
 * 来源：牛客网
 * <p>
 * 盼望着，盼望着，东风来了，春天脚步近了。
 * <p>
 * 值此大好春光，老师组织了同学们出去划船，划船项目收费如下：
 * <p>
 * 双人船最多坐两人，也可以坐一人，收费{a}a元
 * <p>
 * 三人船最多坐三人，也可以坐两人或者一人，收费{b}b元
 * <p>
 * 本次出游加上带队老师共{n}n人，如何安排能使得花费最小呢？
 * <p>
 * 输入描述:
 * 第一行给出一个正整数 T(1 \le T \le 1000)T(1≤T≤1000)，代表测试数据的组数。
 * <p>
 * 接下来 {T}T 行每行给出三个正整数n, a, b,1 \le n,a,b \le 10^9n,a,b,1≤n,a,b≤10
 * 9
 * ，含义如题。
 * 输出描述:
 * 每组输入输出一行，代表最小的花费
 * <p>
 * <p>
 * 示例1
 * 输入
 * 复制
 * 2
 * 2 20 200
 * 3 20 20
 * 输出
 * 复制
 * 20
 * 20
 *
 * @author Ikarosx
 * @date 2021/03/20
 */
public class E春游 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt();
            // 双人船
            int a = scanner.nextInt();
            // 三人船
            int b = scanner.nextInt();

        }
    }
}
