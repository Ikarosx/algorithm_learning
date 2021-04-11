package interview.meituan20210411;

import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2021/04/11
 */
public class D合成宝石 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 合成到n级需要多少钱
        long[] mergeMap = new long[7];
        mergeMap[1] = 0;
        for (int i = 2; i < mergeMap.length; i++) {
            mergeMap[i] = mergeMap[i - 1] + (i - 1) * 7890;
        }
        // 计算n级宝石等于多少1级宝石
        long[] map = new long[7];
        map[1] = 1;
        // 2颗1 合2
        // 3颗2 合3
        for (int i = 2; i < map.length; i++) {
            map[i] = map[i - 1] * i;
        }
        // n堆宝石
        int n = scanner.nextInt();
        // 现在有的钱
        long money = 0;
        long one = 0;
        for (int i = 0; i < n; i++) {
            // j颗宝石
            long j = scanner.nextInt();
            // 等级
            int level = scanner.nextInt();
            money += mergeMap[level] * j;
            one += map[level] * j;
        }
        money += one * 1222;
        long num = scanner.nextInt();
        // 需要消耗的钱
        long mergeMoney = 0;
        mergeMoney += 1222 * map[6] * num;
        //mergeMoney += mergeMap[6] * num;
        // 合成消耗
        long count = map[6] * num;
        int level = 1;
        while (count != 0) {
            long mergeCount = count / (level + 1);
            // 合成消耗费用
            mergeMoney += mergeCount * 7890 * level;
            // 升级了
            level++;
            // 升级后的宝石的数量
            count = mergeCount;
        }
        System.out.println(mergeMoney - money);
        scanner.close();
    }
}
