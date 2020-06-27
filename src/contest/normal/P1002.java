package contest.normal;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入要求
 * 每组数据都有两部分：首先输入一个数字N （1<=N<=105)，表示接下来会输入N个数字，请将它倒序输出即可。
 * 输出要求
 * 每个数字后面有一个空格，每组数据输出一行。
 *
 * @author Ikaros
 * @date 2020/4/8 7:09
 */
public class P1002 {
    public static void main(String[] args) {
        /*
         * 用栈，先进后出
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                stack.push(scanner.nextInt());
            }
            while (!stack.empty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
