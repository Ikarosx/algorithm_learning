package interview.携程.携程20201013笔试;

import java.util.Arrays;
import java.util.Scanner;

public class A买饮料 {



    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    /**
     * @param m 需要可乐的数量
     * @param a 10元张数
     * @param b 50元张数
     * @param c 100元张数
     * @param x 可乐单价
     */
    static int buyCoke(int m, int a, int b, int c, int x) {
        // 投硬币次数
        int count = 0;
        // 先投100硬币
        while (m > 0 && c * 100 >= x) {
            //System.out.println("购买一瓶可乐");
            // 需要投硬币的数量
            int num = (x / 100) + (x % 100 == 0 ? 0 : 1);
            //System.out.println("投递100元硬币" + num + "枚");
            // 记上
            count += num;
            // 减掉
            c -= num;
            // 余额
            int yue = num * 100 % x;
            // 找50元
            b += yue / 50;
            //System.out.println("找零50元硬币" + yue / 50 + "枚");
            yue %= 50;
            // 找10元
            a += yue / 10;
            //System.out.println("找零10元硬币" + yue / 10 + "枚");
            m--;
        }
        while (m > 0 && (b * 50 + c * 100) >= x) {
            int temp = x;
            //System.out.println("购买一瓶可乐");
            // 投硬币数量
            if (c > 0) {
                temp -= c * 100;
                count += c;
                c = 0;
            }
            int num = (temp / 50) + (temp % 50 == 0 ? 0 : 1);
            //System.out.println("投递50元硬币" + num + "枚");
            count += num;
            b -= num;
            int yue = num * 50 % temp;
            a += yue / 10;
            //System.out.println("找零10元硬币" + yue / 10 + "枚");
            m--;
        }
        while (m > 0 && (a * 10 + c * 100 + b * 50) >= x) {
            int temp = x;
            //System.out.println("购买一瓶可乐");
            if (c > 0) {
                temp -= c * 100;
                count += c;
                c = 0;
            }
            if (b > 0) {
                temp -= b * 50;
                count += b;
                b = 0;
            }
            // 投硬币数量
            int num = (temp / 10) + (temp % 10 == 0 ? 0 : 1);
            //System.out.println("投递10元硬币" + num + "枚");
            count += num;
            a -= num;
            m--;
        }
        return count;

    }

    /**
     * @param m 还需要买的可乐数量
     * @param c 纸币数量
     * @param x 可乐单价
     * @param price 纸币的价格
     */
    private static int[] buyCokeImpl(int m, int c, int x, int price) {
        if (m <= 0) {
            return new int[]{0, 0, 0, 0, 0};
        }
        int count = 0;
        // 100元全投可以买的可乐数量
        int buyBy100 = c * price / x;
        if (m < buyBy100) {
            // 100元能买的可乐大于需要买的可乐
            count += (x * m / price) + (x * m % price == 0 ? 0 : 1);
            return new int[]{0, count, 0, 0, 0};
        } else {
            m -= buyBy100;
            count += c;
        }
        int yue = c * 100 % x;
        int c100 = yue / 100;
        yue -= c100 * 100;
        int c50 = yue / 50;
        yue -= c50 * 50;
        int c10 = yue / 10;
        return new int[]{m, count, c10, c50, c100};
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        //System.out.println(String.valueOf(res));

    }
}
