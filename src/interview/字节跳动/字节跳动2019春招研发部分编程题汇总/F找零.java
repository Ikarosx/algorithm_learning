package interview.字节跳动.字节跳动2019春招研发部分编程题汇总;

import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
 *
 * 输入描述:
 * 一行，包含一个数N。
 *
 * 输出描述:
 * 一行，包含一个数，表示最少收到的硬币数。
 *
 * 输入例子1:
 * 200
 *
 * 输出例子1:
 * 17
 *
 * 例子说明1:
 * 花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
 *
 * @author Ikarosx
 * @date 2020/10/11 8:49
 */
public class F找零 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1024 - scanner.nextInt();
        int result = 0;
        int[] ints = {64, 16, 4, 1};
        for (int cost : ints) {
            result += i / cost;
            i %= cost;
        }
        System.out.println(result);
    }
}
