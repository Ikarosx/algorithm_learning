package interview.meituan20210411;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * M队和T队将要进行射箭比赛，M队的队长是小美，T队的队长是小团。这场射箭比赛的规则是，每个队员都可以选择一个距离进行射击，若射中靶心且距离小于等于d则团队得1分，若射中靶心且距离大于d则团队得2分。小团对敌我情况了如指掌，他知道接下来M队将会有n名队员射中靶心，且知道这些队员选择的射箭距离，以及自己所带领的T队会有m名队员射中靶心和他们选择的射箭距离。假定d的值可以由小团确定（d的范围恒为[1,1000]），小团想知道自己的队伍最多能赢小美的队伍多少分（T队得分减去M队得分的最大值）。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行两个正整数n，m，分别表示M队射中靶心的队员个数和T队射中靶心的队员个数。
 * <p>
 * 接下来一行n个整数a1,a2,...,an表示M队中n个队员的射箭距离。
 * <p>
 * 在接下来一行m个整数b1,b2,...,bm表示T队中m个队员的射箭距离。
 * <p>
 * 输出描述
 * 一行一个整数，表示T队最多能赢M队的分数。
 * <p>
 * <p>
 * 样例输入
 * 2 3
 * 585 375
 * 936 317 185
 * 样例输出
 * 2
 * <p>
 * 提示
 * 1≤n,m≤100000,1≤ai,bi≤1000
 *
 * @author Ikarosx
 * @date 2021/04/11
 */
public class B比赛 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // M队射中靶心的队员个数
        int m = scanner.nextInt();
        // T队射中靶心的队员个数
        int t = scanner.nextInt();
        // M队队员射箭距离
        int[] mDistance = new int[m];
        for (int i = 0; i < mDistance.length; i++) {
            mDistance[i] = scanner.nextInt();
        }
        // T队队员射箭距离
        int[] tDistance = new int[t];
        for (int i = 0; i < tDistance.length; i++) {
            tDistance[i] = scanner.nextInt();
        }
        Arrays.sort(mDistance);
        Arrays.sort(tDistance);

        // 计算T队最多能赢多少分
        // M: 375 585 1000
        // T: 185 317 936 1000
        int result = t * 2 - m * 2;
        int ml = 0;
        int tl = 0;
        int mPoint = m * 2;
        int tPoint = t * 2;
        while (ml < m || tl < t) {
            if (ml == m) {
                // 说明m队已经结束了,都是1分
                // 此时调大d只会使T队分数更少
                break;
            }
            if (tl == t) {
                // 此时t已经结束了
                // 调大d可以使M队分数更少，达到更大的数值
                result = Math.max(result, t - m);
                break;
            }
            if (tDistance[tl] < mDistance[ml]) {
                tPoint--;
                tl++;
            } else if (tDistance[tl] == mDistance[ml]) {
                tPoint--;
                mPoint--;
                tl++;
                ml++;
            } else if (tDistance[tl] > mDistance[ml]) {
                mPoint--;
                result = Math.max(result, tPoint - mPoint);
                ml++;
            }
        }
        System.out.println(Math.max(result, 0));
        scanner.close();

    }
}
