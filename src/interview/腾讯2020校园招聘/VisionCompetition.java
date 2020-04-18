package interview.腾讯2020校园招聘;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,
 * 即可以看作是[0,L]的一条数轴。
 * 这款竞技游戏当中有n个可以提供视野的道具−真视守卫,
 * 第i个真视守卫能够覆盖区间[xi,yi]。
 * 现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。
 * <p>
 * 输入描述:
 * 输入包括n+1行。
 * <p>
 * 第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)
 * <p>
 * 接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。
 * <p>
 * <p>
 * 输出描述:
 * 一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
 * <p>
 * 输入例子1:
 * 4 6
 * 3 6
 * 2 4
 * 0 2
 * 4 7
 * <p>
 * 输出例子1:
 * 3
 *
 * @author Ikaros
 * @date 2020/4/13 20:08
 */
public class VisionCompetition {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n个守卫
        int n = scanner.nextInt();
        // 河道长L
        int L = scanner.nextInt();
        // 先x后y
        int[][] ints = new int[n][2];
        int result = 0;
        for (int i = 0; i < n; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }
        Arrays.sort(ints, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            }
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return 1;
        });
        int current = 0;
        int i = 0;
        while (current < L) {
            int tempCurrent = current;
            boolean find = false;
            for (int j = i; j < ints.length; j++) {
                int l = ints[j][0];
                int r = ints[j][1];
                if (r <= current) {
                    continue;
                }
                if (l > current) {
                    break;
                }
                if (tempCurrent < r) {
                    find = true;
                    i = j;
                    tempCurrent = r;
                }
            }
            if (!find) {
                break;
            } else {
                current = tempCurrent;
                result++;
            }
        }
        System.out.println(current < L ? -1 : result);
    }
    
    
}
