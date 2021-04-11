package interview.meituan20210411;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 定义一个字符串为关键串当且仅当该串中出现次数最多的字符严格超过了字符总数（即串长）的一半。
 * <p>
 * 例如字符串"a","aab","aaab","abccc"是关键串，而"ab","abc","aabb","abcc"不是。
 * <p>
 * 给一个长度为n的字符串s，有多少个子串是关键串？
 * <p>
 * 子串：对于一个给定的字符串，串中任意个连续的字符组成的子序列称为该串的子串。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行是一个正整数n，表示字符串的长度。
 * <p>
 * 第二行是一个长度为n的仅包含小写字母的字符串s。
 * <p>
 * 输出描述
 * 输出一行，表示字符串s中是关键串的子串个数。
 * <p>
 * <p>
 * 样例输入
 * 5
 * ccccb
 * 样例输出
 * 14
 * <p>
 * 提示
 * 14个符合关键串定义的子串分别为"c","c","c","c","b","cc","cc","cc","ccc","ccc","ccb","cccc","cccb","ccccb"
 * <p>
 * 1≤n≤100000
 *
 * @author Ikarosx
 * @date 2021/04/11
 */
public class D关键串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int result = 0;
        // 遍历开头
        for (int i = 0; i < chars.length; i += 2) {
            Map<Character, Integer> map = new HashMap<>();
            int maxCount = 0;
            int maxCharacter = '0';
            // 右扩展
            for (int j = i; j < chars.length; j++) {
                char c = chars[j];
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) > maxCount) {
                    maxCharacter = c;
                    maxCount = map.get(c);
                }
                if (maxCount > (j - i + 1) / 2) {
                    result++;
                }
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
