package collection.GDEI2019程序设计比赛;

import java.util.Scanner;

/**
 * 据说HBUT ACM TEAM 内部经过研究发现：貌似一个游戏对人产生的影响值等与游戏的英文名有关~~~~
 * <p>
 * 据说是计算方式是这样的：
 * <p>
 * DOTA = 1*4 + 2*15 + 3*20 + 4*1 = 98
 * <p>
 * WAR CRAFT = 1*23 + 2*1 + 3*18 + 4*0 + 5*3 + 6*18 + 7*1
 * +8*6 + 9*20 = 437
 * <p>
 * 也就是说这个值等于每个英文字母在字母表中的位置（A=1,B=2,…Z=26,空格视为0）乘上在游戏名中的位置。
 * <p>
 * 现在给出一行单词，希望由你来算出它们的值。
 *
 * @author Ikaros
 * @date 2020/5/5 18:51
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // nextLine得到一行包括空格，如果是next则拿不到空格
            String string = scanner.nextLine();
            // 保存结果
            int result = 0;
            // #结束
            if (string.equals("#")) {
                break;
            }
            // 通过题意可知，A-Z代表1-26，空格代表0，然后用值*当前字符的位置（索引+1）
            for (int i = 0; i < string.length(); i++) {
                // 拿到字符
                char c = string.charAt(i);
                // 先让当前字符值为0，刚好代表了是空格
                int value = 0;
                // 如果当前字符不是空格
                if (c != ' ') {
                    // 那么让值等于当前字符-A+1
                    // 字符是可以转成int的
                    // 如果当前字符是A，那么A-A = 0，所以要让A字符代表A需要-A后加一
                    // 如果当前字符是B，那么B-A+1=2，符合B的值为0
                    // 这是按照ASCII表排序的
                    value = c - 'A' + 1;
                }
                // 然后用位置*值，累加即可
                result += (i + 1) * value;
            }
            // 每次获取到一行就输出结果
            // 这个格式很重要，注意观察给的input和output
            System.out.println(result);
        }
        scanner.close();
    }
}
