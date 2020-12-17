package interview.百度.百度2017春招笔试真题;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 *
 * 输入描述:
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 *
 * 输出描述:
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 *
 * 输入例子1:
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 *
 * 输出例子1:
 * 30
 *
 * @author Ikarosx
 * @date 2020/10/12 14:06
 */
public class A买帽子 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        int result = -1;
        if (set.size() >= 3) {
            int i = 3;
            for (Integer integer : set) {
                i--;
                if (i == 0) {
                    result = integer;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
