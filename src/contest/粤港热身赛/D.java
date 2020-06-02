package collection.粤港热身赛;

import java.util.Scanner;

/**
 * 找出字符串中出现次数最多的字母，并在出现次数最多的字母后面输出（出现了x次）（注意：括号是中文括号！）
 * <p>
 * 输入要求
 * 由小写英文字母组成的长度不超过200的字符串
 * <p>
 * 输出要求
 * 一个字符串
 *
 * @author Ikaros
 * @date 2020/4/18 21:27
 */
public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int[] ints = new int[256];
        for (int i = 0; i < string.length(); i++) {
            ints[string.charAt(i)]++;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
                index = i;
            }
        }
        System.out.println(string.replaceAll(String.valueOf((char) index), String.format("%s（出现了%d次）", (char) index, ints[index])));
        scanner.close();
    }
}
