package wejudge.粤港澳资格赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/25 17:07
 */
public class P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][][] array = new int[n + 1][2][5];
        for (int i = 1; i <= n; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                array[i][0][i1] = scanner.nextInt();
            }
            // array[i][1][0] = 第i天如果去1自习室则最多去图书馆的时间
            // 由前一天的2,3,4自习室、昨天休息以及今天的自习室开放情况决定
            int[] compare = new int[4];
            if (array[i][0][0] == 1) {
                // 开放
                compare[0] = array[i - 1][1][1];
                compare[1] = array[i - 1][1][2];
                compare[2] = array[i - 1][1][3];
                compare[3] = array[i - 1][1][4];
                Arrays.sort(compare);
                array[i][1][0] = compare[3] + 1;
            } else {
                array[i][1][0] = array[i - 1][1][0];
            }
            // array[i][1][1] = 第i天如果去2自习室则最多去图书馆的时间
            if (array[i][0][1] == 1) {
                // 开放
                compare[0] = array[i - 1][1][0];
                compare[1] = array[i - 1][1][2];
                compare[2] = array[i - 1][1][3];
                compare[3] = array[i - 1][1][4];
                Arrays.sort(compare);
                array[i][1][1] = compare[3] + 1;
            } else {
                array[i][1][1] = array[i - 1][1][1];
            }
            // array[i][1][2] = 第i天如果去3自习室则最多去图书馆的时间
            if (array[i][0][2] == 1) {
                // 开放
                compare[0] = array[i - 1][1][0];
                compare[1] = array[i - 1][1][1];
                compare[2] = array[i - 1][1][3];
                compare[3] = array[i - 1][1][4];
                Arrays.sort(compare);
                array[i][1][2] = compare[3] + 1;
            } else {
                array[i][1][2] = array[i - 1][1][2];
            }
            // array[i][1][3] = 第i天如果去4自习室则最多去图书馆的时间
            if (array[i][0][3] == 1) {
                // 开放
                compare[0] = array[i - 1][1][0];
                compare[1] = array[i - 1][1][1];
                compare[2] = array[i - 1][1][2];
                compare[3] = array[i - 1][1][4];
                Arrays.sort(compare);
                array[i][1][3] = compare[3] + 1;
            } else {
                array[i][1][3] = array[i - 1][1][3];
            }
            // array[i][1][4] = 第i天如果留在宿舍则最多去图书馆的时间
            // 留在宿舍
            int[] newCompare = new int[5];
            newCompare[0] = array[i - 1][1][0];
            newCompare[1] = array[i - 1][1][1];
            newCompare[2] = array[i - 1][1][2];
            newCompare[3] = array[i - 1][1][3];
            newCompare[4] = array[i - 1][1][4];
            Arrays.sort(newCompare);
            array[i][1][4] = newCompare[4];
        }
        int[] newCompare = new int[5];
        newCompare[0] = array[n][1][0];
        newCompare[1] = array[n][1][1];
        newCompare[2] = array[n][1][2];
        newCompare[3] = array[n][1][3];
        newCompare[4] = array[n][1][4];
        Arrays.sort(newCompare);
        System.out.println(newCompare[4]);
        scanner.close();
    }
}
