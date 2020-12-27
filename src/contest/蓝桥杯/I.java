package contest.蓝桥杯;

import java.util.Scanner;

/**
 * 给定一个单词，请问在单词中删除 t 个字母后，能得到的字典序最小的单词是什么？
 * 输入格式
 * 　　输入的第一行包含一个单词，由大写英文字母组成。
 * 　　第二行包含一个正整数 t。
 * 输出格式
 * 　　输出一个单词，表示答案
 * 样例输入
 * LANQIAO
 * 3
 * 样例输出
 * AIAO
 * 数据规模和约定
 * 　　对于所有评测用例，单词长度不超过 100，t 小于单词长度。
 *
 * @author Ikarosx
 * @date 2020/12/27 19:09
 */
public class I {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int t = scanner.nextInt();
        while (t > 0) {
            for (int i = 0; i < string.length() - 1; i++) {
                char c = string.charAt(i);
                char nc = string.charAt(i + 1);
                if (c > nc) {
                    // 第一个数比第二个数大
                    string = string.replaceFirst(String.valueOf(c), "");
                    t--;
                    break;
                }
                if (i == string.length() - 2) {
                    string = string.replaceFirst(String.valueOf(nc), "");
                    t--;
                    break;
                }
            }
        }
        System.out.println(string);
    }
}
