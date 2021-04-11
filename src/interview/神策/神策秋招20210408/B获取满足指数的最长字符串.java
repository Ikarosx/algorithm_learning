package interview.神策.神策秋招20210408;

import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2021/04/09
 */
public class B获取满足指数的最长字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().toLowerCase();
        long n = scanner.nextLong();
        int l = 0;
        int r = 0;
        long temp = 0;
        long length = string.length();
        long result = 0;
        // TODO
        while (r < length) {
            // 小了就右扩
            if (temp == n) {
                temp -= string.charAt(l) - 'a' + 1;
                l++;
            }
            // 大了左缩
            while (l < length && temp > n) {
                temp -= string.charAt(l) - 'a' + 1;
                l++;
            }
            if (temp == n) {
                result = Math.max(result, r - l);
                temp -= string.charAt(l) - 'a' + 1;
                l++;
            }
        }
        System.out.println(result);

    }


}
