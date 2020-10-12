package interview.字节跳动.字节跳动2019春招研发部分编程题汇总;

import java.util.Scanner;

public class B万万没想到之抓捕孔连顺 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 建筑物数量
        int N = scanner.nextInt();
        // 两个特工最大距离
        int D = scanner.nextInt();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = scanner.nextInt();
        }
        // 找到 [i,j],使得buildings[j] - buildings[i] <= D
        // 结果 += (j - i + 1)! / (j - i - 2)!
        // i = j - 1
        int i = 0;
        int right = 2;
        long result = 0;
        while (i < N - 2) {
            int temp = buildings[i];
            while (right < N && buildings[right] - temp <= D) {
                right++;
            }
            result += calc(right - i - 1);
            i++;
        }
        System.out.println(result % 99997867);
    }


    // 计算n选3,不重复,C n 3
    public static long calc(long n) {
        if (n < 2) {
            return 0;
        }
        return n * (n - 1) / 2;
    }
}