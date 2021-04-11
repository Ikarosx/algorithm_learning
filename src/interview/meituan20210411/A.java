package interview.meituan20210411;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 小美和小团居住的城市有n座房子呈一条直线排列,相邻两房子间隔相同,第i座房子编号为i.小美知道小团的房子可能在某些房子中,他想买一套房子使得距离小团可能所在房子的期望距离尽可能小,同时又不超过k元钱,于是向你求助.
 *
 * @author Ikarosx
 * @date 2021/04/11
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n座房子
        int n = scanner.nextInt();
        // 不超过k元
        int k = scanner.nextInt();
        int[] houses = new int[n];
        List<Integer> zeros = new LinkedList<>();
        for (int i = 0; i < houses.length; i++) {
            houses[i] = scanner.nextInt();
            if (houses[i] == 0) {
                // 小美可能在价格为0的房间内
                zeros.add(i);
            }
        }
        int minDistance = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < houses.length; i++) {
            int price = houses[i];
            if (price != 0 && price <= k) {
                // 计算期望距离
                int calcMinDistanceTemp = calcMinDistance(i, zeros);
                if (calcMinDistanceTemp < minDistance) {
                    minDistance = calcMinDistanceTemp;
                    result = i;
                }
            }
        }
        System.out.println(result + 1);
        scanner.close();
    }

    private static int calcMinDistance(int i, List<Integer> zeros) {
        int result = 0;
        for (Integer zero : zeros) {
            result += Math.abs(zero - i);
        }
        return result;
    }

}
