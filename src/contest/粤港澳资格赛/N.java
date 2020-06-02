package collection.粤港澳资格赛;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Ikaros
 * @date 2020/4/25 15:13
 */
public class N {
    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(7));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Integer[][] array = new Integer[n * n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i * n + j][0] = scanner.nextInt();
                    array[i * n + j][1] = calcTen(i, j);
                }
            }
            Arrays.sort(array, Comparator.comparing(o -> o[1]));
            int k;
            int v;
            for (int i = 0; i < array.length; i++) {
                k = array[i][0];
                v = 1;
                while (i + 1 < array.length && array[i + 1][0].equals(array[i][0])) {
                    i++;
                    v++;
                }
                System.out.print(String.format("%d,%d ", k, v));
            }
        }
        scanner.close();
    }
    
    private static int calcTen(int i, int j) {
        String row = Integer.toBinaryString(i);
        String column = Integer.toBinaryString(j);
        int rL = row.length();
        int cL = column.length();
        StringBuilder zero = new StringBuilder();
        if (rL < cL) {
            int d = cL - rL;
            for (int i1 = 0; i1 < d; i1++) {
                zero.append('0');
            }
            row = zero.toString() + row;
        }
        if (cL < rL) {
            int d = rL - cL;
            for (int i1 = 0; i1 < d; i1++) {
                zero.append('0');
            }
            column = zero.toString() + column;
        }
        StringBuilder tenString = new StringBuilder();
        for (int i1 = 0; i1 < row.length(); i1++) {
            tenString.append(row.charAt(i1));
            tenString.append(column.charAt(i1));
        }
        return Integer.valueOf(tenString.toString(), 2);
        
        
    }
}
