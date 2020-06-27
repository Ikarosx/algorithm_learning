package interview.拼多多.校招2020;

import java.util.Scanner;

/**
 * 多多鸡打算造一本自己的电子字典，里面的所有单词都只由a和b组成。
 * 每个单词的组成里a的数量不能超过N个且b的数量不能超过M个。
 * 多多鸡的幸运数字是K，它打算把所有满足条件的单词里的字典序第K小的单词找出来，作为字典的封面。
 *
 * @author Ikaros
 * @date 2020/6/6 14:19
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // a的数量不能超过N个且b的数量不能超过M个
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            long K = scanner.nextLong();
            // 先从没有B的开始
            // 即前面有N个a
            //
        }
        scanner.close();
    }
}
