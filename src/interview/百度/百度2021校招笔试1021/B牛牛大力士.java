package interview.百度.百度2021校招笔试1021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ikarosx
 * @date 2020/10/12 19:48
 */
public class B牛牛大力士 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 选手数量
            int n = scanner.nextInt();
            // 比赛场次
            int m = scanner.nextInt();
            // 牛牛编号
            int p = scanner.nextInt();
            // map<key ,value> 表示key赢了谁
            HashMap<Integer, List<Integer>> winerMap = new HashMap<>();
            // map<key ,value> 表示key输给了谁
            HashMap<Integer, List<Integer>> loserMap = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int winer = scanner.nextInt();
                int loser = scanner.nextInt();
                winerMap.putIfAbsent(winer, new ArrayList<>());
                loserMap.putIfAbsent(loser, new ArrayList<>());
                winerMap.get(winer).add(loser);
                loserMap.get(loser).add(winer);
            }
            List<Integer> pWinerList = winerMap.getOrDefault(p, new ArrayList<>());
            List<Integer> pLoserList = loserMap.getOrDefault(p, new ArrayList<>());
            int startSize = pLoserList.size();
            int endSize = n - pWinerList.size();
            for (int i = startSize + 1; i <= endSize; i++) {
                System.out.print(i + "");
            }
        }
        scanner.close();
    }
}
