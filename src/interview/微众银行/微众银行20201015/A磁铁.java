package interview.微众银行.微众银行20201015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 假想一个绝对光滑的，高度很高的盒子，长度为n，宽度为1。在其中，有许多1*1*1的光滑铁块，铁块的每一个角一定位于整数坐标上。
 *
 * 由于宽度为1，我们可以用二维字符图来表示每一个铁块的位置。如下图是一个长度为4，其中有7个铁块的二维字符图（'x'代表铁块，'o'代表没有铁块）：
 *
 * oooo xooo xoxo xxxx
 *
 * 每一列的铁块数分别为3,1,2,1
 *
 * 由于重力的缘故，所有的铁块要么下面是盒子底面，要么下面是另一个铁块。现在，在盒子的右边增加一个强磁铁。所有右边没有其他铁块或边界的铁块会向右移动，直到撞上一个铁块和边界停下。
 *
 * 在上一张二维图上，加入磁铁后的字符图会变为：
 *
 * oooo
 *
 * ooox
 *
 * ooxx
 *
 * xxxx
 *
 * 每一列的铁块数分别为1,1,2,3。可以证明，这样操作后所有铁块要么下面是盒子底面，要么下面是另一个铁块。 现在给你初始每一列有多少个铁块，请你计算，加入磁铁后每一列有多少铁块。
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个数n，代表盒子的长度 接下来n个数，空格隔开，代表每一列原本有多少个铁块。
 *
 * 输出描述
 * 输出n个数，空格隔开，代表加入磁铁后每一列有多少个铁块。
 *
 *
 * 样例输入
 * 4
 * 3 1 2 1
 * 样例输出
 * 1 1 2 3
 *
 * 提示
 * 数据范围：n≤10^5,每一列铁块数不会超过10^5
 *
 * @author Ikarosx
 * @date 2020/10/15 20:25
 */
public class A磁铁 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            Arrays.sort(ints);
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + " ");
            }
        }
        scanner.close();
    }
}
