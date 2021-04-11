package interview.meituan20210411;


import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 给一个长度为n的只包含0和1的序列，每次可以使用魔法消除相邻的3个数。在可以用任意次魔法的前提下，0的个数和1的个数的最大差值为多少？输出这个最大差值。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行是一个正整数n，表示序列的长度。
 * <p>
 * 第二行是只包含0和1的序列，其长度为n。
 * <p>
 * 输出描述
 * 输出一个整数，表示这个最大差值。
 * <p>
 * <p>
 * 样例输入
 * 5
 * 00001
 * 样例输出
 * 3
 * <p>
 * 提示
 * n≤100000
 *
 * @author Ikarosx
 * @date 2021/04/11
 */
public class C消除 {

    // 00011
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 序列长度
        int n = scanner.nextInt();
        // 序列
        String sequence = scanner.next();
        System.out.println(Math.max(countD(sequence), countD(reverse(sequence))));
        scanner.close();
    }

    private static int countD(String sequence) {
        // 统计以0为主的最大差值
        int zeros = 0;
        int one = 0;
        char[] chars = sequence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                // 为0直接加0
                zeros++;
            } else {
                // 为1判断最近三位有多少个1
                int count1 = countOne(i, chars);
                if (count1 >= 2) {
                    if (i == chars.length - 2) {
                        zeros--;
                    }
                    // 跳过后2位
                    i += 2;
                    continue;
                }
                one++;
            }
        }
        return Math.abs(zeros - one);
    }

    private static int countOne(int i, char[] chars) {
        int one = 1;
        if (i + 1 < chars.length && chars[i + 1] == '1') {
            one++;
        }
        if (i + 2 < chars.length && chars[i + 2] == '1') {
            one++;
        }
        return one;
    }

    private static String reverse(String sequence) {
        char[] chars = sequence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }
        return new String(chars);
    }
}
