package wejudge.粤港热身赛;

import java.util.Scanner;

/**
 * 小明今年上一年级了，他特别喜欢玩积木，于是非常喜欢他的数学老师斯捷就给了他三种不同的莫斯方块，
 * 莫斯方块是非常神奇的方块，它只有1 * 1， 1 * 2 和 2 * 2的正方形组成。如下图：
 * <p>
 * 现在斯捷老师希望小明可以用一定数量的这三种莫斯方块尽量多的拼凑出3 * 3的莫斯方块。请聪明的你帮帮小明，不然小明可能会留级了。
 * 输入要求
 * 每次先输入一个整数T（1 <= T <= 1000000），接下来T组测试数据
 * 对于每一组数据有三个整数a, b, c (0 <= a, b, c <= 100），
 * 分别代表1 * 1、 1 * 2 和 2 * 2的莫斯方块数
 * 输出要求
 * 对于每组测试数据，输出格式为"Case #i: ans"，表示第i组测试数据答案为ans。
 * 表示最多可以拼凑出ans个3 * 3的莫斯方块
 *
 * @author Ikaros
 * @date 2020/4/18 20:16
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                array[0] = scanner.nextInt();
                array[1] = scanner.nextInt();
                array[2] = scanner.nextInt();
                System.out.println(String.format("Case #%d: %d", i + 1, mosi(array)));
            }
        }
        scanner.close();
    }
    
    private static int mosi(int[] array) {
        int count = 0;
        int a = array[0];
        int b = array[1];
        int c = array[2];
        
        if (a >= 9) {
            count++;
            array[a] -= 9;
            mosi(array);
            array[a] += 9;
        }
        if (a >= 1 && b >= 4) {
            count++;
            array[a] -= 1;
            array[b] -= 4;
            mosi(array);
            array[a] += 1;
            array[b] += 4;
        }
        if (a >= 1 && b >= 2 && c >= 1) {
            count++;
            array[a] -= 1;
            array[b] -= 2;
            array[c] -= 1;
            mosi(array);
            array[a] += 1;
            array[b] += 2;
            array[c] += 1;
        }
        return count;
    }
    
    
}
