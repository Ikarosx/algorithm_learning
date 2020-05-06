package wejudge.GDEI2019程序设计比赛;

import java.util.Scanner;

/**
 * 奶牛打保龄球时不使用实际的保龄球。它们各自取一个数字（在0..99范围内），然后排成一个标准的保龄球状三角形，如下所示：
 * <p>
 * 7
 * <p>
 * <p>
 * <p>
 * 3   8
 * <p>
 * <p>
 * <p>
 * 8   1   0
 * <p>
 * <p>
 * <p>
 * 2   7   4   4
 * <p>
 * <p>
 * <p>
 * 4   5   2   6   5
 * 然后其他奶牛从其尖端开始穿过三角形并“向下”移动到两个对角相邻的奶牛中的一个，
 * 直到到达“底部”行。奶牛的得分是沿途参观的奶牛数量的总和。得分最高的母牛赢得了那个框架。
 * <p>
 * 给定具有N（1 <= N <= 350）行的三角形，确定可实现的最高可能总和。
 *
 * @author Ikaros
 * @date 2020/5/5 20:04
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[][] nums = new int[N][N];
            // 为了简单就是用了N*N，实际上应该可以压缩成不浪费的数组
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            // 从倒数第二行向上计算
            // 将当前值下一行的左右两个数比较，取大数加在当前值上
            // 重复往上，最后第一行的第一个值就是最大值
            for (int n = N - 2; n >= 0; n--) {
                for (int i = 0; i <= n; i++) {
                    nums[n][i] += Math.max(nums[n + 1][i], nums[n + 1][i + 1]);
                }
            }
            System.out.println(nums[0][0]);
        }
        scanner.close();
    }
}
