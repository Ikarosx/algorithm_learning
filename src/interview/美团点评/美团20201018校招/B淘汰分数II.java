package interview.美团点评.美团20201018校招;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。
 *
 * 但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。
 *
 * 显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。
 *
 *
 *
 * 输入描述
 * 输入第一行仅包含三个正整数n,x,y，中间用空格隔开，分别表示参赛的人数和晋级淘汰人数区间。(1<=n<=50000,1<=x,y<=n)
 *
 * 输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=a_i<=1000)
 *
 * 输出描述
 * 输出仅包含一个整数，如果不存在这样的m，则输出-1，否则输出符合条件的最小的值。
 *
 *
 * 样例输入
 * 6 2 3
 * 1 2 3 4 5 6
 * 样例输出
 * 3
 *
 * @author Ikarosx
 * @date 2020/10/18 10:10
 */
public class B淘汰分数II {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 参赛人数
            int n = scanner.nextInt();
            // 保证晋级和淘汰的人数都在[x, y]中
            // 左区间
            int x = scanner.nextInt();
            // 右区间
            int y = scanner.nextInt();
            // 存储成绩
            int[] ints = new int[n];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = scanner.nextInt();
            }
            Arrays.sort(ints);
            int result = -1;
            // array[i]表示左边比它小的数的数量
            int[] array = new int[n];
            for (int i = 1; i < n; i++) {
                if (ints[i] > ints[i - 1]) {
                    array[i] = array[i - 1] + 1;
                } else {
                    array[i] = array[i - 1];
                }
                if (array[i] >= x && n - array[i] <= y) {
                    result = ints[i - 1];
                    break;
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
