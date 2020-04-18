package interview.腾讯2020校园招聘;

import java.util.Scanner;

/**
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，
 * 一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，
 * 所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
 * （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 * <p>
 * 输入描述:
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=wi<=100000;
 * <p>
 * 输出描述:
 * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 * <p>
 * 输入例子1:
 * 6
 * 5 3 8 3 2 5
 * <p>
 * 输出例子1:
 * 3 3 5 4 4 4
 *
 * @author Ikaros
 * @date 2020/4/13 16:34
 */
public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println(shopping(ints));
        scanner.close();
    }
    
    private static String shopping(int[] ints) {
        
        // 遍历两遍， 数量 = 向右看 + 向左看 + 自己
        // ints1[i]表示下标为i的元素向右看能看到且大于自身的个数
        // ints2[i]表示下标为i的元素向左看能看到且大于自身的个数
        
        // 编码：ints1中最右边为0，其他往左的数计算方式：
        // 找到右边第一个大于自己的数，下标为j，ints1[i] = ints1[j] + 1
        int[] ints1 = new int[ints.length];
        // 向右看
        for (int i = ints.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < ints.length && ints[i] > ints[j]) {
                j++;
            }
            // 此时j应该为第一个大于ints1[i]的数，或者已经到最右边了
            if (j == ints.length) {
                // 如果到底了，可能小于也可能是大于
                if (ints[j - 1] > ints[i]) {
                    ints1[i]++;
                }
            } else {
                ints1[i] = ints1[j] + 1;
            }
        }
        // 存左看
        int[] ints2 = new int[ints.length];
        // 向左看
        for (int i = 1; i < ints2.length; i++) {
            int j = i - 1;
            while (j >= 0 && ints[i] > ints[j]) {
                j--;
            }
            // 此时j应该为左边第一个大于ints1[i]的数，或者已经到最左边了
            if (j == -1) {
                // 如果到底了，可能小于也可能是大于
                if (ints[j + 1] > ints[i]) {
                    ints2[i]++;
                }
            } else {
                ints2[i] = ints2[j] + 1;
            }
        }
        StringBuilder result = new StringBuilder();
        // 计算ints1和ints2
        // 遍历数组，计算右边：如果ints[i] > ints[i + 1]，则temp = ints[i + 1] + 1, 否则 temp = ints[i + 1]
        for (int i = 0; i < ints1.length; i++) {
            int temp = 0;
            // 右边
            if (i + 1 < ints1.length) {
                temp += ints1[i + 1] + 1;
            }
            // 左边
            if (i - 1 >= 0) {
                temp += ints2[i - 1] + 1;
            }
            temp++;
            result.append(temp + " ");
        }
        return result.toString();
    }
    
}
