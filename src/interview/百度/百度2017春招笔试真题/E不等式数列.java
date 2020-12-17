package interview.百度.百度2017春招笔试真题;

import java.util.Scanner;

/**
 * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
 *
 * 输入描述:
 * 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
 *
 * 输出描述:
 * 输出满足条件的排列数,答案对2017取模。
 *
 * 输入例子1:
 * 5 2
 *
 * 输出例子1:
 * 66
 *
 * @author Ikarosx
 * @date 2020/10/12 17:22
 */
public class E不等式数列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // n个整数
            int n = scanner.nextInt();
            // lt个小于符号
            int lt = scanner.nextInt();
            // gt个大于符号
            int gt = n - lt - 1;

        }
        scanner.close();
    }
}
