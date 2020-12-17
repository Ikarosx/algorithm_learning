package interview.微众银行.微众银行20201015;

import java.util.Scanner;
import org.junit.Test;

/**
 * 时间限制： 3000MS
 * 内存限制： 655360KB
 * 题目描述：
 * 现在你在玩一款游戏，叫做节奏小师。它有三种判定
 *
 * P : Perfect 完美，加200分。
 *
 * G : Great 很棒，加100分。
 *
 * M : Miss 错过，不加分也不扣分，但累计三次Miss就会输掉游戏。
 *
 * 另外有一种奖励是连击奖励。一旦连续三个Perfect之后，后续连击的Perfect分数将变成250分，但一旦打出了Great或者Miss则连击数将重新开始计算。
 *
 * 你的任务是根据游戏记录计算分数。特别地，失败记为零分。
 *
 *
 *
 * 输入描述
 * 一行一个字符串，描述你的游戏记录。
 *
 * 保证字符串长度小于等于10000
 *
 * 输出描述
 * 一行一个正整数表示得分
 *
 *
 * 样例输入
 * PPPPPGPPMP
 * 样例输出
 * 1800
 *
 * @author Ikarosx
 * @date 2020/10/15 20:29
 */
public class B节奏小师 {

    @Test
    public void test() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("P");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // PPPPPGPPMP 1800
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            // 分数
            int point = 0;
            // 连续P次数
            int pCount = 0;
            // 累计miss 3次失败
            int mCount = 0;
            for (char c : chars) {
                if (c == 'P') {
                    // p次数+1
                    pCount++;
                    // 如果之前已经连续三次Perfect，加250分，否则200
                    point += pCount > 3 ? 250 : 200;
                } else if (c == 'G') {
                    // great 100分
                    point += 100;
                    // p置零
                    pCount = 0;
                } else {
                    // miss次数++
                    mCount++;
                    pCount = 0;
                    if (mCount == 3) {
                        point = 0;
                        break;
                    }
                }
            }
            System.out.println(point);
        }
        scanner.close();
    }
}
