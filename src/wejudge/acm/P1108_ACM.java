package wejudge.acm;

import java.util.Scanner;

/**
 * 为了准备今年的樱高祭，Mio酱写了首新曲子，但是排练时总是会出现各种问题。
 * 她们需要知道哪里契合度最好，哪里契合度不好，这样才能把时间利用地更有效率。
 * 输入要求
 * 输入数据有多组，每组第一行输入一个正整数n（1<=n<=100），
 * 接下来一行输入n个整数ai（1 <= ai <=7），表示Mio酱曲子的音谱；
 * 接着一行输入n个整数bi（1 <= bi <= 7），表示排练时曲子的音谱。
 * 输入到文件结束。
 * <p>
 * 输出要求
 * 对于每组输入，输出一行。若曲子完美契合（即两份音谱完全相同），则输出“^_^”，表示Mio酱很高兴；若曲子部分契合（即两份音谱存在相同的地方），则输出最契合的一段连续的音谱，若答案有多组，则输出以Mio酱的音谱为准最靠前的一段；如果两份音谱完全不契合，Mio酱会认为都是自己的错，会认为自己会嫁不出去，这时程序应输出“T_T”，表示Mio酱很伤心。
 * 你可以通过样例获取更多信息。（两段音谱的契合部分不一定下标对应）
 * <p>
 * 输入输出
 * 5
 * 1 2 3 4 5
 * 1 2 3 4 5
 * 10
 * 1 1 1 2 2 2 3 3 3 4
 * 3 3 3 2 2 2 1 1 1 4
 * 6
 * 1 2 3 4 5 6
 * 7 7 7 7 7 7
 * 10
 * 1 1 1 1 2 2 2 2 1 3
 * 4 4 4 1 1 1 1 1 3 3
 * ^_^
 * 1 1 1
 * T_T
 * 1 1 1 1
 *
 * 测试用例
 * 1.完全相同
 * 2.完全不相同
 * 3.部分相同
 *  3.1 位置
 *      3.1.1 相同在开头
 *      3.1.2 相同在中间
 *      3.1.3 相同在结尾
 *  3.2 符合的数量
 *      3.2.1 只有一个
 *      3.2.2 有2个
 *          3.2.2.1 前面的长
 *          3.2.2.2 后面的长
 *      3.2.3 有3个及以上
 *          3.2.3.1 前面的长
 *          3.2.3.2 中间的长
 *          3.2.3.3 后面的长
 *
 * @author Ikaros
 * @date 2020/4/15 17:05
 */
public class P1108_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 音谱数量
            int n = scanner.nextInt();
            int[] aints = new int[n];
            int[] bints = new int[n];
            for (int i = 0; i < aints.length; i++) {
                aints[i] = scanner.nextInt();
            }
            for (int i = 0; i < bints.length; i++) {
                bints[i] = scanner.nextInt();
            }
            int l = 0;
            int r = -1;
            for (int i = 0; i < aints.length; i++) {
                // 遍历a数组，对a数组中的数遍历b数组中相等的值，找不到相等的则i++
                // 找到了之后查找出最长相等，记录下来，i更新为最长的位置
                int ar = -1;
                int j = 0;
                while (j < bints.length) {
                    int m = i;
                    if (bints[j] == aints[m]) {
                        while (j + 1 < bints.length && m + 1 < aints.length && bints[j + 1] == aints[m + 1]) {
                            j++;
                            m++;
                        }
                        // 此时m为a数组中当前找到的最右值
                        // 当找到的值大于保存的值时更新最右值
                        ar = m > ar ? m : ar;
                        // 因为此时j为bints中的相等部分的最右，j+1已经不相等，有可能相等的是j+2
                        j += 2;
                    } else {
                        // 两个不相等
                        j++;
                    }
                }
                if (ar == -1) {
                    continue;
                }
                if (ar - i > r - l) {
                    l = i;
                    r = ar;
                }
                i = ar;
            }
            if (r - l + 1 == n) {
                System.out.println("^_^");
            } else if (r - l + 1 == 0) {
                System.out.println("T_T");
            } else {
                for (int i = l; i <= r; i++) {
                    System.out.print(aints[i]);
                    if (i != r) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
