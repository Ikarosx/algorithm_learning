package interview.神策.神策秋招20210408;

import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2021/04/09
 */
public class C字符串翻转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().replaceAll(" +", " ");
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (String string : strings) {
            int length = string.length();
            for (int i = 0; i < length; i++) {
                stringBuilder.append(string.charAt(length - i - 1));
            }
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }
}
