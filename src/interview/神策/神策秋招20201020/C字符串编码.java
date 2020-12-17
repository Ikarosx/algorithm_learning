package interview.神策.神策秋招20201020;

import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/20 16:35
 */
public class C字符串编码 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            char c = string.charAt(0);
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                char c1 = string.charAt(i);
                if (c1 == c) {
                    count++;
                } else {
                    builder.append(c);
                    builder.append(count);
                    c = c1;
                    count = 1;
                }
                // 特判，结尾
                if (i == string.length() - 1) {
                    builder.append(c);
                    builder.append(count);
                }
            }
            System.out.println(builder.toString());
        }
        scanner.close();
    }
}
