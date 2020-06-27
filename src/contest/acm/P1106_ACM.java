package contest.acm;

import java.util.Scanner;

/**
 * 宇宙纪年0096年，地球联邦军同新吉翁军之间再次燃起战火。
 * 你，作为地球联邦军第14级舰的舰长，将率领14级舰全员全力反击进击的敌人。
 * 现在你的军舰上有一门威力巨大的光束炮，然而它现在剩下的能量只能再发射一次。
 * 为了使敌人受到更大的损失，你必须谨慎地使用这仅剩的一次机会。
 * 敌军队形和光束炮的覆盖范围均为矩形(矩形不可旋转)。
 * <p>
 * 输入要求
 * 输入数据有多组，每组第一行是两个整数n和m（1 <= n, m <= 30），表示敌军队形的宽和高；
 * 接下来的m行，每行有n个整数ai（1<=ai<=100），每个整数表示敌军每个机动战士的价值；
 * 接着一行是两个整数w和h（1 <= w, h <= 30），表示你的光束炮的覆盖覆盖范围的宽和高。输入以EOF结束。
 * <p>
 * 输出要求
 * 对于多组输入数据，每组输出一行，每行一个整数，表示敌军可能受到的最大损失。
 *
 * @author Ikaros
 * @date 2020/4/8 17:47
 */
public class P1106_ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 敌军队形 宽
            int n = scanner.nextInt();
            // 敌军队形 高
            int m = scanner.nextInt();
            int[][] temp = new int[m][n];
            // 临时空间存放数据
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = scanner.nextInt();
                }
            }
            // w、h表示光炮爆炸范围的宽高
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            // 补全数组，其他地方为0，解决光炮爆炸范围大于敌军队形
            int[][] ints = new int[m > h ? m : h][n > w ? n : w];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ints[i][j] = temp[i][j];
                }
            }
            System.out.println(countMaxDamage(ints, ints[0].length, ints.length, w, h));
        }
        scanner.close();
    }
    
    /**
     *
     * @param ints
     * @param n 敌军宽
     * @param m 敌军高
     * @param w 光炮宽
     * @param h 光炮高
     * @return
     */
    private static int countMaxDamage(int[][] ints, int n, int m, int w, int h) {
        // 从二维数组的第一行开始，计算[m][n]到[m + h - 1][n + w - 1]的总数
        // m从[0,m-h]，n从[0,n-w]
        int max = 0;
        for (int i = 0; i <= m - h; i++) {
            boolean first = true;
            // 存储每行的值
            int tempMax = 0;
            for (int j = 0; j <= n - w; j++) {
                if (first) {
                    // 每行的第一个计算[m][n]到[i + h - 1][j + w - 1]整个方格
                    for (int g = i; g <= i + h - 1 && g <= m; g++) {
                        for (int f = j; f <= j + w - 1 && f <= n; f++) {
                            tempMax += ints[g][f];
                        }
                    }
                    
                    first = false;
                } else {
                    // 当不是第一个之后，可以很简单地整个方块往右移，加上右边，减掉左边
                    for (int g = i; g <= i + h - 1 && g <= m; g++) {
                        // 减掉左边
                        tempMax -= ints[g][j - 1];
                        // 加上右边
                        tempMax += ints[g][j + w - 1];
                    }
                }
                // 取最大值
                max = max > tempMax ? max : tempMax;
            }
        }
        return max;
    }
    
}
