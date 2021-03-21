package contest.牛客.牛客小白月赛32;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/11163/B
 * 来源：牛客网
 * <p>
 * 给出单个原子的相对原子质量，计算化学式的相对分子质量。
 * 输入描述:
 * 第一行中给出两个正整数M,N,1 \le M \le 100,1 \le N \le 20M,N,1≤M≤100,1≤N≤20
 * <p>
 * 接下来M行每行给出一个以大写字母开头的字符串S和一个正整数X，S为元素名称，X为相对原子质量
 * <p>
 * 最后N行每行给出一个化学式，保证化学式长度不超过50个字符
 * <p>
 * 元素可能是一个大写字母，也可能是一个大写字母跟着一个小写字母，保证给出的M种化学元素互不相同
 * <p>
 * 化学式包含括号以及括号嵌套，例如：Ba((OH)2(CO3)2)3
 * <p>
 * 注：保证化学式使用给出的元素符号，但不保证该物质真实存在
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 输出N行，每行一个相对分子质量，数据保证相对分子质量在long long范围内
 * 示例1
 * 输入
 * 复制
 * 2 2
 * H 1
 * O 16
 * H2
 * H2O
 * 输出
 * 复制
 * 2
 * 18
 *
 * @author Ikarosx
 * @date 2021/03/20
 */
public class B相对分子质量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // M行映射
        int M = scanner.nextInt();
        // N行化学式
        int N = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            map.put(scanner.next(), scanner.nextInt());
        }
        for (int i = 0; i < N; i++) {
            String string = scanner.next();
            long result = 0;
            char[] chars = string.toCharArray();
            Deque<String> stack = new ArrayDeque<>();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == '(' || c == ')') {
                    stack.push(String.valueOf(c));
                    continue;
                }
                //if (c >='0')
            }
        }

    }
}
