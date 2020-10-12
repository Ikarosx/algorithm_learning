package interview.字节跳动.字节跳动2019春招研发部分编程题汇总;

/**
 * @author Ikarosx
 * @date 2020/10/10 22:29
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
 * 于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：
 *
 * 总共有36张牌，每张牌是1~9。每个数字4张牌。
 * 你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
 * 14张牌中有2张相同数字的牌，称为雀头。
 * 除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
 *
 * 例如：
 * 1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
 * 1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
 * 1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。
 *
 * 现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
 *
 * 输入描述:
 * 输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。
 *
 * 输出描述:
 * 输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0
 *
 * 输入例子1:
 * 1 1 1 2 2 2 5 5 5 6 6 6 9
 *
 * 输出例子1:
 * 9
 *
 * 例子说明1:
 * 可以组成1,2,6,7的4个刻子和9的雀头
 *
 * 输入例子2:
 * 1 1 1 1 2 2 3 3 5 6 7 8 9
 *
 * 输出例子2:
 * 4 7
 *
 * 例子说明2:
 * 用1做雀头，组123,123,567或456,789的四个顺子
 *
 * 输入例子3:
 * 1 1 1 2 2 2 3 3 3 5 7 7 9
 *
 * 输出例子3:
 * 0
 *
 * 例子说明3:
 * 来任何牌都无法和牌
 */
public class C雀魂启动 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int[i]表示 i 有多少张
        int[] ints = new int[10];
        for (int i = 0; i < 13; i++) {
            ints[scanner.nextInt()]++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] != 4) {
                ints[i]++;
                // 去掉雀头
                for (int j = 1; j < ints.length; j++) {
                    if (ints[j] >= 2) {
                        // 雀头 -2
                        ints[j] -= 2;
                        // 判断剩下的12张能否组成和牌
                        if (judgeValid(ints)) {
                            builder.append(i).append(" ");
                        }
                        // 雀头 +2
                        ints[j] += 2;
                    }
                }
                ints[i]--;
            }
        }
        if (builder.length() == 0) {
            builder.append("0");
        }
        System.out.println(builder.toString());
    }

    // 判断是否是和牌
    private static boolean judgeValid(int[] ints) {
        int[] copyInts = Arrays.copyOf(ints, ints.length);
        // 遍历所有ints[i] == 1
        for (int i = 1; i < copyInts.length; i++) {
            // 说明 ints[i, i + 1, i + 2] - 1, i + 1
            int count = copyInts[i];
            if (count == 0) {

            } else if (count == 1) {
                if (i >= copyInts.length - 2 || copyInts[i + 1] < 1 || copyInts[i + 2] < 1) {
                    // 如果已经不足三位，或者后两位不足1
                    return false;
                }
                copyInts[i] -= 1;
                copyInts[i + 1] -= 1;
                copyInts[i + 2] -= 1;
            } else if (count == 2) {
                if (i >= copyInts.length - 2 || copyInts[i + 1] < 2 || copyInts[i + 2] < 2) {
                    // 如果已经不足三位，或者后两位不足2
                    return false;
                }
                copyInts[i] -= 2;
                copyInts[i + 1] -= 2;
                copyInts[i + 2] -= 2;
            } else if (count == 3) {
                copyInts[i] -= 3;
            } else {
                // 4
                copyInts[i--] -= 3;
            }
        }
        return true;
    }
}
