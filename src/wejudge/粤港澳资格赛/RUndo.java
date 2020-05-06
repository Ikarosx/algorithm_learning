package wejudge.粤港澳资格赛;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * Luhhy老师最近在研究字符串，只含有字符“a”和“b”的字符串。
 * <p>
 * 她想定义一类串为孤独的串，这类串的特点是串中存在某个字符“a”，它只与“b”相邻。
 * <p>
 * 如“babaa”是孤独的串，因为第一个“a”左右两边都是“b”。“aaba”也是，因为最后一个“a”的存在使该串符合条件。
 * <p>
 * 特殊的，一个只含有“b“的串不是孤独的串。
 * <p>
 * 现在，给一个正整数n，Luhhy想知道长度为n的孤独的串的数量有多少个。
 * <p>
 * 输入要求
 * 输入数据第一行是一个正整数 T (1<=T<=100)，表示数据组数。
 * <p>
 * 接下来 T 行每行一个正整数 n (1<=n<=100)，表示字符串长度。
 * <p>
 * 输出要求
 * 对于每组输入，输出一行，表示孤独的串的数量。
 *
 * @author Ikaros
 * @date 2020/4/25 12:44
 */
public class RUndo {
    @Test
    public void test() {
        int i = 0;
        i -= 1 + 3;
        System.out.println(i);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] array = new int[101];
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;
        for (int i = 4; i < array.length; i++) {
            int result = 0;
            double pow = Math.pow(2, i - 2);
            result += pow;
            for (int i1 = 1; i1 <= i / 2; i1++) {
                pow /= 2;
                result += pow;
            }
            for (int i1 = i / 2 + 1; i1 < i; i1++) {
                result += pow;
                pow *= 2;
            }
            array[i] = result;
        }
        // a 后面是b
        for (int i = 0; i < T; i++) {
            System.out.println(array[scanner.nextInt()]);
        }
        
        scanner.close();
    }
}
