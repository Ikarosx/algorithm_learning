package collection.粤港澳资格赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/25 15:57
 */
public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            int[][] array = new int[3][3];
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    array[j][k] = string.charAt(j * 3 + k) - '0';
                }
            }
            // 计算特征值
            int[] ts = new int[4];
            ts[0] = ft(array);
            rotate90(array);
            ts[1] = ft(array);
            rotate90(array);
            ts[2] = ft(array);
            rotate90(array);
            ts[3] = ft(array);
            Arrays.sort(ts);
            System.out.println(ts[0]);
        }
        scanner.close();
    }
    
    private static void rotate90(int[][] array) {
        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                temp[i][i1] = array[i][i1];
            }
        }
        array[0][0] = temp[2][0];
        array[0][1] = temp[1][0];
        array[0][2] = temp[0][0];
        array[1][0] = temp[2][1];
        array[1][2] = temp[0][1];
        array[2][0] = temp[2][2];
        array[2][1] = temp[1][2];
        array[2][2] = temp[0][2];
    }
    
    private static int ft(int[][] array) {
        int result = 0;
        result += (array[1][1] ^ array[0][0]) * (1 << 7);
        result += (array[1][1] ^ array[0][1]) * (1 << 6);
        result += (array[1][1] ^ array[0][2]) * (1 << 5);
        result += (array[1][1] ^ array[1][2]) * (1 << 4);
        result += (array[1][1] ^ array[2][2]) * (1 << 3);
        result += (array[1][1] ^ array[2][1]) * (1 << 2);
        result += (array[1][1] ^ array[2][0]) * (1 << 1);
        result += (array[1][1] ^ array[1][0]);
        return result;
    }
}
